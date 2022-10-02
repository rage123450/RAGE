package Netty.Packet

import EventID
import NetError
import Netty.OutPacket

object Login {

    fun ECH_VERIFY_ACCOUNT_ACK(UserUID: Long, acc: String, password: String): OutPacket {
        val outPacket = OutPacket(NetError.NET_OK)
        outPacket.encodeString(password)
        outPacket.encodeLong(UserUID)
        outPacket.encodeString(acc)
        outPacket.encodeString("")
        outPacket.end(EventID.ECH_VERIFY_ACCOUNT_ACK)
        return outPacket
    }
}