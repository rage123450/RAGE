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
        try {
            val first = outPacket.op == EventID.E_ACCEPT_CONNECTION_NOT.op
            val data = c.EncryptPacket(outPacket, first)
            val hmacdata = DESCrypt.getHmacMD5Data(if(first) DESCrypt.DEFAULT_HMAC_KEY else c.packetHmac, data)
            bb.writeIntLE(4 + 4 + data.size + HMAC_SIZE)
            bb.writeIntLE(c.packetnum)
            bb.writeBytes(data)
            bb.writeBytes(hmacdata)
        } finally {
            c.releaseEncodeState()
        }

    }
}