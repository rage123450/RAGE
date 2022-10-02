package Handlers

import EventID
import NetError
import Netty.InPacket
import Netty.NettyClient
import Netty.OutPacket
import Netty.Packet.Login
import Users
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object LoginHandler {

    fun ECH_VERIFY_ACCOUNT_REQ(c: NettyClient, inPacket: InPacket) {
        inPacket.decodeByte()
        val acc = inPacket.decodeString()
        val password = inPacket.decodeString()
        println("帳號: $acc 密碼: $password")

        var result = NetError.NET_OK

        lateinit var UserId: EntityID<Long>

        transaction {
            val userData = Users.select { Users.name.eq(acc) }.firstOrNull()
            if (userData == null) {
                result = NetError.ERR_VERIFY_04
            } else if (!userData?.get(Users.password).equals(password)) {
                result = NetError.ERR_VERIFY_06
            } else {
                UserId = userData.get(Users.id)
            }
        }

//        var a = User(UserId)

//        println("$result ID $UserId")

        when (result) {
            NetError.ERR_VERIFY_04 -> c.write(OutPacket(result, EventID.ECH_VERIFY_ACCOUNT_ACK))
            NetError.NET_OK -> {
                c.write(Login.ECH_VERIFY_ACCOUNT_ACK(UserId.value/*a.id.value*/, acc/*a.name*/, password/*a.password*/))
            }
            else -> {}
        }

    }
}