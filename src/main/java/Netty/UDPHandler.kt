package network.netty

import EventID_UDP
import EventID_UDP.XPT_PORT_CHECK_ACK
import EventID_UDP.XPT_PORT_CHECK_REQ
import Netty.InPacket
import Netty.NettyClient
import Netty.OutPacket
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.socket.DatagramPacket
import util.Util
import java.util.*

class UDPHandler : SimpleChannelInboundHandler<DatagramPacket>() {

    override fun channelRead0(ctx: ChannelHandlerContext, datagramPacket: DatagramPacket) {
        val c = ctx.channel().attr(NettyClient.CLIENT_KEY).get()
        val buffer = datagramPacket.content()
        if (c == null || buffer.readableBytes() < 1) return

        val op = buffer.readByte().toInt()
        val data = ByteArray(buffer.readableBytes())
        buffer.readBytes(data)
        val dec = data/*Util.uncompress(data)*/
        val ID = EventID_UDP.getEventIDByOp(op)
        val UDPIP = datagramPacket.sender().toString()
        println(String.format("$UDPIP [UDP In]\t| %s, %d/0x%s\t| %s", if (ID == null) "未知" else ID, op,
            Integer.toHexString(op).uppercase(Locale.getDefault()),
            Util.readableByteArray(Arrays.copyOfRange(dec, 0, dec.size))))
        val inPacket = InPacket(dec, true)

        when (ID) {
            XPT_PORT_CHECK_REQ -> { // 接收 0x11 (玩家帳號ID) FE A5 A2 3B 00 00 00 00 (玩家內網IP) 7F 00 00 01 (玩家UDP port) 32 22
                val accid = inPacket.decodeLong()

                val outPacket = OutPacket(true)
//                outPacket.encodeString(UDPIP.split(":".toRegex()).toTypedArray()[0].substring(1)) // 127.0.0.1
                outPacket.encodeArr(byteArrayOf(127, 0, 0, 1.toByte()))
                outPacket.encodeIntLE(datagramPacket.sender().port) // 8583
                outPacket.end(XPT_PORT_CHECK_ACK)
                c.UDPwrite(outPacket, datagramPacket.sender())
            }
            else -> {
                if (!EventID_UDP.isSpam(ID)) println(String.format("[未處理]\t| %s", ID))
            }
        }

        inPacket.release()
    }

    private fun handleUnknown(inPacket: InPacket, opCode: Int) {
//        if (!InHeader.isSpamHeader(InHeader.getInHeaderByOp(opCode))) {
        println(String.format("UDP 未處理 opcode %s/0x%s, packet %s",
            opCode,
            Integer.toHexString(opCode).uppercase(Locale.getDefault()),
            inPacket))
//        }
    }
}