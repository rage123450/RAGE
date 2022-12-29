package Netty

import EventID
import handlers
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import java.io.IOException
import java.lang.reflect.Method

class ChannelHandler : SimpleChannelInboundHandler<InPacket>() {

    override fun channelRead0(ctx: ChannelHandlerContext, inPacket: InPacket) {
        val c = ctx.channel().attr(NettyClient.CLIENT_KEY).get() as NettyClient

        val op = EventID.getEventIDByOp(inPacket.header)
        val method: Method? = handlers.get(op)
        try {
            if (method == null) {
                if (op != null) {
                    println("找不到處理方法 $op")
                }
            } else {
                method.invoke(this, c, inPacket)

/*                val clazz = method.parameterTypes[0]
                try {
                    when {
                        method.parameterTypes.size == 3 -> {
                            method.invoke(this, chr, inPacket, inHeader)
                        }
                        clazz == Client::class.java -> {
                            method.invoke(this, c, inPacket)
                        }
                        clazz == Char::class.java -> {
                            method.invoke(this, chr, inPacket)
                        }
                        else -> {
                            println("Unhandled first param type of handler " + method.name + ", type = " + clazz)
                        }
                    }
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                } catch (e: InvocationTargetException) {
                    e.printStackTrace()
                }*/
            }
        } finally {
            inPacket.release()
        }
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