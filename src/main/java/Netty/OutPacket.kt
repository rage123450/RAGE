package Netty

import EventID
import EventID_UDP
import NetError
import UTF16LE
import UTF8
import io.netty.buffer.ByteBufUtil
import io.netty.buffer.Unpooled
import util.Position
import util.Rect
import util.Util
import java.util.*

class OutPacket {
    private val buf = Unpooled.buffer()
    lateinit var data: ByteArray
    var op = 0
    var udp = false
    var compress = false

    constructor()

    constructor(m_iOK: NetError) {
        buf.writeInt(m_iOK.value)
    }

    constructor(m_iOK: NetError, op: EventID) {
        buf.writeInt(m_iOK.value)
        end(op)
    }

    constructor(b: Boolean) {
        udp = b
    }

    /**
     * Encodes a byte to this OutPacket.
     *
     * @param b The byte to encode.
     */
    fun encodeByte(n: Number) {
        buf.writeByte(n.toInt())
    }

    /**
     * Encodes a byte array to this OutPacket.
     * Named like this to prevent autocompletion of "by" to "byteArray" or similar names.
     *
     * @param bArr The byte array to encode.
     */
    fun encodeArr(bArr: ByteArray?) {
        buf.writeBytes(bArr)
    }

    fun encodeArr(s: String) {
        buf.writeBytes(Util.getByteArrayByString(s))
    }

    /**
     * Encodes a character to this OutPacket, UTF-8.
     *
     * @param c The character to encode
     */
    fun encodeChar(c: Char) {
        buf.writeByte(c.code)
    }

    /**
     * Encodes a boolean to this OutPacket.
     *
     * @param b The boolean to encode (0/1)
     */
    fun encodeBoolean(b: Boolean) {
        buf.writeBoolean(b)
    }

    fun encodeBooleanInt(b: Boolean) {
        buf.writeInt(if(b) 1 else 0)
    }

    /**
     * Encodes a short to this OutPacket, in little endian.
     *
     * @param s The short to encode.
     */

    fun encodeShort(n: Number) {
        buf.writeShort(n.toInt())
    }

    fun encodeInt(n: Number) {
        buf.writeInt(n.toInt())
    }

    fun encodeIntLE(n: Number) {
        buf.writeIntLE(n.toInt())
    }

    fun encodeLong(n: Number) {
        buf.writeLong(n.toLong())
    }

    fun encodeString(s: String) = encodeString(s, true)

    fun encodeString(s: String, W: Boolean) {
        val sa = s.toByteArray(if(W) UTF16LE else UTF8)
        encodeInt(sa.size)
        if (sa.isNotEmpty()) {
            encodeArr(sa)
        }
    }

    fun encodeFloat(f: Float) {
        buf.writeFloat(f)
    }

    fun encodeDouble(d: Double) {
        buf.writeDouble(d)
    }

    fun end (id: EventID) {
        end (id, false)
    }

    fun end (id: EventID, c: Boolean) {
        op = id.op
        compress = c
        data = ByteBufUtil.getBytes(buf);
    }

    fun end (id: EventID_UDP) {
        op = id.op
        data = ByteBufUtil.getBytes(buf);
    }

    override fun toString(): String {
        val ID = if (udp) EventID_UDP.getEventIDByOp(op) else EventID.getEventIDByOp(op)
        return String.format(
            "%s, %s/0x%s\t| %s", ID, op,
            Integer.toHexString(op).uppercase(Locale.getDefault()),
            Util.readableByteArray(Arrays.copyOfRange(data, 0, data.size))
        )
    }

    fun encodePosition(position: Position?) {
        if (position != null) {
            encodeFloat(position.x)
            encodeFloat(position.y)
            encodeFloat(position.z)
        } else {
            encodeFloat(0F)
            encodeFloat(0F)
            encodeFloat(0F)
        }
    }

    fun encodeRectInt(rect: Rect) {
        encodeFloat(rect.left)
        encodeFloat(rect.top)
        encodeFloat(rect.right)
        encodeFloat(rect.bottom)
    }

    fun encodeTime(dynamicTerm: Boolean, time: Int) {
        encodeBoolean(dynamicTerm)
        encodeInt(time)
    }

    fun encodeTime(time: Int) {
        encodeBoolean(false)
        encodeInt(time)
    }
}
