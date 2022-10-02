package Netty

import EventID
import EventID.*
import Handlers.LoginHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import server
import util.Util
import java.io.IOException

class ChannelHandler : SimpleChannelInboundHandler<InPacket>() {

    override fun channelRead0(ctx: ChannelHandlerContext, inPacket: InPacket) {
        val c = ctx.channel().attr(NettyClient.CLIENT_KEY).get() as NettyClient
        when (val ID = EventID.getEventIDByOp(inPacket.header)) {
            ECH_VERIFY_ACCOUNT_REQ -> LoginHandler.ECH_VERIFY_ACCOUNT_REQ(c, inPacket)

            ECH_GET_CHANNEL_LIST_REQ -> {
                val outPacketA = OutPacket()
                outPacketA.encodeInt(0)
                outPacketA.end(ECH_GET_CHANNEL_LIST_ACK)
                c.write(outPacketA)

                val outPacketN = OutPacket()
                outPacketN.encodeInt(0)
                outPacketN.encodeInt(server.channels.size)
                for (i in 1..server.channels.size) {
                    outPacketN.encodeInt(i)
                    outPacketN.encodeInt(i * 3)
                    outPacketN.encodeInt(i)
                    outPacketN.encodeString(server.getChannelById(i).nName)
                    outPacketN.encodeInt(0)
                    outPacketN.encodeString("127.0.0.1")
                    outPacketN.encodeShort(server.getChannelById(i).nPort/*9300*/)
                    outPacketN.encodeShort(server.getChannelById(i).nPort/*9301*/)
                    outPacketN.encodeInt(1000) // 最大人數
                    outPacketN.encodeInt(0) // 目前人數
                    outPacketN.encodeInt(0)
                    outPacketN.encodeInt(0)
                    outPacketN.encodeByte(1)
                    outPacketN.encodeByte(1)
                    outPacketN.encodeInt(0)
                }
                outPacketN.encodeArr("00 00 00 0E 00 00 00 01 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 02 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 03 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 04 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 05 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 06 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 07 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 08 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 09 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 0A 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 0B 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 0C 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 0D 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00 00 00 00 0E 01 00 00 00 01 00 00 00 63 00 00 00 00 00 00 00 00")
                outPacketN.end(ECH_GET_CHANNEL_LIST_NOT)
                c.write(outPacketN)
            }
            ECH_DISCONNECT_REQ -> {
                val outPacket = OutPacket()
                outPacket.end(ECH_DISCONNECT_ACK)
                c.write(outPacket)
            }
            EGS_CONNECT_REQ -> {
                val version = inPacket.decodeString()
                println("版本: $version")
                val outPacket = OutPacket()
                outPacket.encodeInt(0) // ok
                outPacket.encodeInt(9400/*9301*/) // UDP port
                outPacket.encodeInt(0) // m_iChannelID
                outPacket.end(EGS_CONNECT_ACK)
                c.write(outPacket)
            }
            EGS_VERIFY_ACCOUNT_REQ -> {
/*                inPacket.decodeString(false) // 密碼
                inPacket.decodeByte();
                inPacket.decodeString(false)
                inPacket.decodeInt()
                inPacket.decodeByte()
                val version = inPacket.decodeString()
                val unk = inPacket.decodeString() // 1
                val account = inPacket.decodeString()*/

                val outPacket = OutPacket()
                outPacket.encodeInt(0)
                outPacket.encodeLong(1/*0*/) // 帳號id
                outPacket.encodeString("123456"/*account*/)
                outPacket.encodeString("123456"/*account*/)
                outPacket.encodeInt(0)
                outPacket.encodeBoolean(false)
                outPacket.encodeBoolean(true)
                outPacket.encodeString("") // 時間
                outPacket.encodeString("?? ??") // Reason
                outPacket.encodeLong(0)
                outPacket.encodeBoolean(true)
                outPacket.encodeBoolean(false)
                outPacket.encodeString("123456") // 密碼
                outPacket.encodeString("") // 日期
                outPacket.encodeString("") // 日期
                outPacket.encodeBoolean(false)
                outPacket.encodeInt(0)
                outPacket.encodeInt(0)
                outPacket.encodeLong(0)
                outPacket.encodeBoolean(false)
                outPacket.encodeString("127.0.0.1")
                outPacket.encodeArr("00 00 00 00 00 00 00 00 00 00 6C BD 6A AB D1 C3 13 54 02 A0 DC A6 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00")
                outPacket.end(EGS_VERIFY_ACCOUNT_ACK)
                c.write(outPacket)

                val outPacket2 = OutPacket()
                outPacket2.encodeBoolean(false)
                outPacket2.encodeArr("FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 26 32 00 30 00 32 00 32 00 2D 00 31 00 30 00 2D 00 30 00 31 00 20 00 30 00 37 00 3A 00 30 00 35 00 3A 00 30 00 37 00 00 00 FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 52 08 00 00 4E 20 00 00 00 01 00 00 52 08 00 00 4E 20 00 00 00 02 01 00 00 00 09 00 02 DA AC 00 02 DA AB 00 02 D5 36 00 02 DA AD 00 02 DA F9 00 02 DA FA 00 02 DA FB 00 02 DA FC 00 02 DA FD 02 00 00 00 0B 00 02 D5 30 00 02 D5 31 00 02 D5 32 00 02 D5 33 00 02 D5 34 00 02 D5 35 00 02 D5 36 00 02 D5 37 00 02 D5 8A 00 02 D5 8B 00 02 D5 3A")
                outPacket2.end(ENX_USER_LOGIN_NOT)
                c.write(outPacket2)
            }
            EGS_STATE_CHANGE_SERVER_SELECT_REQ -> {
                val outPacket = OutPacket()
                outPacket.encodeInt(0)
                outPacket.end(EGS_STATE_CHANGE_SERVER_SELECT_ACK)
                c.write(outPacket)
            }
            EGS_CURRENT_TIME_REQ -> {
                val outPacket = OutPacket()
                outPacket.encodeString(Util.currentTimeString)
                outPacket.encodeArr("00 00 00 00 63 37 76 23 FF FF FF FF FF FF 8F 80 00 00 12 64 11 95 F7 AB 00 00 02 50")
                outPacket.end(EGS_CURRENT_TIME_ACK)
                c.write(outPacket)
            }
            EGS_SELECT_SERVER_SET_REQ -> {
                val outPacket = OutPacket()
                outPacket.encodeInt(0)
                outPacket.encodeString("127.0.0.1")
                outPacket.encodeShort(9400/*9300*/)
                outPacket.encodeString("")
                outPacket.encodeString("")
                outPacket.encodeArr("00 00 00 00 00 00 00 00 00")
                outPacket.end(EGS_SELECT_SERVER_SET_ACK)
                c.write(outPacket)
            }
            EGS_CHARACTER_LIST_REQ -> {
                val outPacket = OutPacket()
                outPacket.encodeBoolean(false)
                outPacket.encodeArr("FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 26 32 00 30 00 32 00 32 00 2D 00 31 00 30 00 2D 00 30 00 31 00 20 00 30 00 37 00 3A 00 30 00 35 00 3A 00 30 00 37 00 00 00 FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 52 08 00 00 4E 20 00 00 00 01 00 00 52 08 00 00 4E 20 00 00 00 02 01 00 00 00 09 00 02 DA AC 00 02 DA AB 00 02 D5 36 00 02 DA AD 00 02 DA F9 00 02 DA FA 00 02 DA FB 00 02 DA FC 00 02 DA FD 02 00 00 00 0B 00 02 D5 30 00 02 D5 31 00 02 D5 32 00 02 D5 33 00 02 D5 34 00 02 D5 35 00 02 D5 36 00 02 D5 37 00 02 D5 8A 00 02 D5 8B 00 02 D5 3A")
                outPacket.end(ENX_USER_LOGIN_NOT)
                c.write(outPacket)
/*                val outPacket2 = OutPacket()
                outPacket2.encodeArr(ByteArray(6000))
                outPacket2.end(EGS_CHARACTER_LIST_1ST_ACK) // 1206
                c.write(outPacket2)*/
                val outPacket3 = OutPacket()
                outPacket3.encodeArr(ByteArray(1000))
                outPacket3.end(EGS_CHARACTER_LIST_ACK)
                c.write(outPacket3)
            }

            EGS_MY_UNIT_AND_INVENTORY_INFO_LIST_REQ -> { // 這不知道是什麼
                val outPacket = OutPacket()
                outPacket.encodeInt(0)
                outPacket.end(EGS_MY_UNIT_AND_INVENTORY_INFO_LIST_ACK)
                c.write(outPacket)
                val outPacket2 = OutPacket()
                outPacket2.encodeArr(ByteArray(1000))
                outPacket2.end(EGS_MY_UNIT_AND_INVENTORY_INFO_LIST_ACK2)
                c.write(outPacket2)
                val outPacket3 = OutPacket()
                outPacket3.encodeArr(ByteArray(1000))
                outPacket3.end(EGS_MY_UNIT_AND_INVENTORY_INFO_LIST_ACK3)
                c.write(outPacket3)
            }
            EGS_DISCONNECT_FOR_SERVER_SELECT_REQ -> {
                val outPacket = OutPacket()
                outPacket.encodeInt(0)
                outPacket.end(EGS_DISCONNECT_FOR_SERVER_SELECT_ACK)
                c.write(outPacket)
            }

            EGS_CREATE_UNIT_REQ -> {
                val unitname = inPacket.decodeString()
                val unitid = inPacket.decodeByte()
                println("欲創建的角色名字: $unitname")
            }

            else -> if (!EventID.isSpam(ID)) println(String.format("[未處理]\t| %s %s", inPacket.header, ID))
        }

        inPacket.release()
    }

    override fun channelInactive(ctx: ChannelHandlerContext) {
        println("[ChannelHandler] | Channel inactive.")
        val o = ctx.channel().attr(NettyClient.CLIENT_KEY).get()
        o?.close()
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        if (cause is IOException) {
            println("Client forcibly closed the game.")
        } else {
            cause.printStackTrace()
        }
    }
}