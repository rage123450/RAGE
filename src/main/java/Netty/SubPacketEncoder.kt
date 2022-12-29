package Netty

import EventID
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

class SubPacketEncoder : MessageToByteEncoder<OutPacket>() {
    override fun encode(chc: ChannelHandlerContext, outPacket: OutPacket, bb: ByteBuf) {
        val c = chc.channel().attr(NettyClient.CLIENT_KEY).get() ?: return
        if (!EventID.isSpam(EventID.getEventIDByOp(outPacket.op))) println("[Sub Out]\t| $outPacket")

        c.acquireEncoderState()
        try {
            c.packetnum++

            val aBuffer = byteArrayOf(
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
                0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
            )
            val data = outPacket.data

            bb.writeIntLE(4 + 4 + 24 + (if (data.size > 0) 7 else 6) + data.size)
            bb.writeIntLE(c.packetnum)

            bb.writeBytes(aBuffer)

            bb.writeShort(outPacket.op)
            bb.writeInt(data.size)
            if (data.size > 0) {
                bb.writeByte(0)
            }
            bb.writeBytes(data)
        } finally {
            c.releaseEncodeState()
        }

    }
}