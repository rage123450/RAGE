package network.netty

import Netty.NettyClient
import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioDatagramChannel

class UDPAcceptor : Runnable {

    override fun run() {
        val port = 9301/*9400*/
        // Taken from http://netty.io/wiki/user-guide-for-4.x.html

        val workerGroup: EventLoopGroup = NioEventLoopGroup()
        try {
            val b = Bootstrap()
            b.group(workerGroup)
            b.channel(NioDatagramChannel::class.java)
            b.handler(object : ChannelInitializer<NioDatagramChannel>() {
                override fun initChannel(ch: NioDatagramChannel) {
                    ch.pipeline().addLast(UDPHandler())
                    val c = NettyClient(ch)
                    ch.attr(NettyClient.CLIENT_KEY).set(c)
//                    ch.attr(Client.CRYPTO_KEY).set(new Crypto())
                }
            })

            // Bind and start to accept incoming connections.
            val f = b.bind(port/*9301*/).sync()
            println(String.format("UDP listening on port %d", port/*9301*/))
            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            workerGroup.shutdownGracefully()
        }
    }
}