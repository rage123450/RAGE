package Netty

//import Game.Channel.GameServer
import Server.GameServer
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel

class SubGameServerAcceptor : Runnable {

    lateinit var gs: GameServer

    override fun run() {
        // Taken from http://netty.io/wiki/user-guide-for-4.x.html
        val bossGroup: EventLoopGroup = NioEventLoopGroup()
        val workerGroup: EventLoopGroup = NioEventLoopGroup()
        try {
            val b = ServerBootstrap()
            b.group(bossGroup, workerGroup)
            b.channel(NioServerSocketChannel::class.java)
            b.childHandler(object : ChannelInitializer<SocketChannel>() {
                override fun initChannel(ch: SocketChannel) {
                    ch.pipeline().addLast(SubPacketDecoder(), ChannelHandler(), SubPacketEncoder())
                    val c = NettyClient(ch)
                    println(String.format("Opened session with %s in SubGameServer[%d]", c.ip, gs.nId))
                    ch.attr(NettyClient.CLIENT_KEY).set(c)
                }
            })

//            b.option(ChannelOption.ALLOCATOR, new PooledByteBufAllocator(true))
            b.childOption(ChannelOption.TCP_NODELAY, true)
            b.childOption(ChannelOption.SO_KEEPALIVE, true)

            // Bind and start to accept incoming connections.
            val f = b.bind(gs.nSubPort).sync()
            println(String.format("SubGameServer[%d] listening on port %d", gs.nId, gs.nSubPort))
            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            workerGroup.shutdownGracefully()
            bossGroup.shutdownGracefully()
        }
    }
}