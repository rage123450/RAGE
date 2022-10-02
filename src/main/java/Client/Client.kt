package game

import Client.User
import Netty.NettyClient
import io.netty.channel.Channel
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class Client(channel: Channel?) : NettyClient(channel) {
    val lock: Lock
    var user: User? = null
    var nChannel: Byte = 0

    init {
        lock = ReentrantLock(true)
    }
}