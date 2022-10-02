/*
    This file is part of Desu: MapleStory v62 Server Emulator
    Copyright (C) 2017  Brenterino <therealspookster@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package Netty

import EventID_UDP
import io.netty.buffer.PooledByteBufAllocator
import io.netty.channel.Channel
import io.netty.channel.socket.DatagramPacket
import io.netty.util.AttributeKey
import java.net.InetSocketAddress
import java.security.SecureRandom
import java.util.concurrent.locks.ReentrantLock

/**
 * Abstraction for Netty channels that contains some attribute keys
 * for important resources used by the client during encryption,
 * decryption, and general functions. <B>Note: Some methods cannot be
 * overridden by descendents due to the nature of the functionality they
 * provide</B>
 *
 * @author Brent
 */
open class NettyClient {

    companion object {
//        public static final AttributeKey<Crypto> CRYPTO_KEY = AttributeKey.valueOf("A");
        val CLIENT_KEY = AttributeKey.valueOf<NettyClient>("C")!!
    }

    /**
     * Channel object associated with this specific client. Used for all
     * I/O operations regarding a MapleStory game session.
     */
    private val ch: Channel?

    /**
     * Lock regarding the encoding of packets to be sent to remote
     * sessions.
     */
    private val lock: ReentrantLock?

    var packetnum = 0
    var packetKey = ByteArray(8)
    var packetHmac = ByteArray(8)
    var packetPrefix  = ByteArray(2)

    /**
     * Empty constructor for child class implementation.
     */
    private constructor() {
        ch = null
        lock = null
    }

    /**
     * Construct a new NettyClient with the corresponding Channel that
     * will be used to write to as well as the send and recv seeds or IVs.
     * @param c the channel object associated with this client session.
     */
    constructor(c: Channel?) {
        SecureRandom().apply {
            nextBytes(packetKey)
            nextBytes(packetHmac)
            nextBytes(packetPrefix)
        }
        ch = c
        lock = ReentrantLock(true) // note: lock is fair to ensure logical sequence is maintained server-side
    }

    /**
     * Writes a packet message to the channel. Gets encoded later in the
     * pipeline.
     * @param msg the packet message to be sent.
     */
    fun write(msg: OutPacket?) {
        ch!!.writeAndFlush(msg)
    }

    fun UDPwrite(msg: OutPacket, UDPIP: InetSocketAddress?) {
        if (!EventID_UDP.isSpam(EventID_UDP.getEventIDByOp(msg.op))) println("$UDPIP [UDP Out]\t| $msg")
        val buf = PooledByteBufAllocator.DEFAULT.buffer()
        buf.writeByte(msg.op)
        buf.writeBytes(msg.data/*Util.compress(msg.data)*/)
        ch!!.writeAndFlush(DatagramPacket(buf, UDPIP))
    }

    /**
     * Closes this channel and session.
     */
    fun close() {
        ch!!.close()
    }

    /**
     * Gets the remote IP address for this session.
     * @return the remote IP address.
     */
    val ip: String
        get() = ch!!.remoteAddress().toString().split(":".toRegex()).toTypedArray()[0].substring(1)

    /**
     * Acquires the encoding state for this specific send IV. This is to
     * prevent multiple encoding states to be possible at the same time. If
     * allowed, the send IV would mutate to an unusable IV and the session would
     * be dropped as a result.
     */
    fun acquireEncoderState() {
        lock!!.lock()
    }

    /**
     * Releases the encoding state for this specific send IV.
     */
    fun releaseEncodeState() {
        lock!!.unlock()
    }

    fun EncryptPacket(outPacket: OutPacket, first: Boolean): ByteArray {
        packetnum++
        return when(first) {
            true -> DESCrypt.encrypt(outPacket.op, packetnum, outPacket.data, outPacket.compress)
            false -> DESCrypt.encrypt(outPacket.op, packetKey, packetHmac, packetPrefix, packetnum, outPacket.data, outPacket.compress)
        }
    }
}