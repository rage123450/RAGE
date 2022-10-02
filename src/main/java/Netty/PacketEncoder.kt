package Netty

import EventID
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

class PacketEncoder : MessageToByteEncoder<OutPacket>() {
    override fun encode(chc: ChannelHandlerContext, outPacket: OutPacket, bb: ByteBuf) {
        val c = chc.channel().attr(NettyClient.CLIENT_KEY).get() ?: return
        if (!EventID.isSpam(EventID.getEventIDByOp(outPacket.op))) println("[Out]\t| $outPacket")

        c.acquireEncoderState()
//        var Header = Util.ShortToByteArray(outPacket.op)
//        var Length = Util.IntToByteArray(outPacket.data.size)
//        var pBuffer = ByteArray(7 + outPacket.data.size)
//        lateinit var buffer: ByteArray
//        println(outPacket.data.size)
        try {
            bb.writeBytes(c.EncryptPacket(outPacket, outPacket.op == EventID.E_ACCEPT_CONNECTION_NOT.op));
        } finally {
            c.releaseEncodeState()
        }
//        bb.writeBytes(buffer)
//        bb.writeIntLE(16 + pBuffer.size + 10)
//        bb.writeIntLE(1) // seq
//        bb.writeBytes(iv) // iv
//        bb.writeBytes(pBuffer)
//        bb.writeBytes(b)
    }
}