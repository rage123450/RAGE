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

/*    constructor(op: EventID) {
        end(op)
    }*/

    constructor(b: Boolean) {
        udp = b
    }

    fun e1() = encodeByte(0)

    fun encodeByte(b: Int) {
        buf.writeByte(b)
    }

    /**
     * Encodes a byte array to this OutPacket.
     * Named like this to prevent autocompletion of "by" to "byteArray" or similar names.
     *
     * @param bArr The byte array to encode.
     */
    fun encodeArr(bArr: ByteArray) {
        for (b in bArr) {
            encodeByte(b.toInt())
        }
    }

    fun encodeArr(s: String) {
        encodeArr(Util.getByteArrayByString(s))
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

    fun e2() = encodeShort(0)

    fun encodeShort(n: Number) {
        buf.writeShort(n.toInt())
    }

    fun e4() = encodeInt(0)

    fun encodeInt(n: Number) {
        buf.writeInt(n.toInt())
    }

    fun encodeIntLE(n: Number) {
        buf.writeIntLE(n.toInt())
    }

    fun e8() = encodeLong(0)

    fun encodeLong(n: Number) {
        buf.writeLong(n.toLong())
    }

    fun es() = encodeString("")

    fun encodeString(s: String) = encodeString(s, true)

    fun encodeString(s: String, wstr: Boolean) {
        val sa = s.toByteArray(
            when {
                wstr -> UTF16LE
                else -> UTF8
            }
        )
        encodeInt(sa.size)
        if (sa.isEmpty()) return
        encodeArr(sa)
    }

    fun encodeFloat(f: Float) {
        buf.writeFloat(f)
    }

    fun encodeDouble(d: Double) {
        buf.writeDouble(d)
    }

    fun end(id: EventID) {
        end(id, false)
    }

    fun end(id: EventID, c: Boolean) {
        op = id.op
        compress = c
        data = ByteBufUtil.getBytes(buf)
    }

    fun end(o: Int) {
        end(o, false)
    }

    fun end(o: Int, c: Boolean) {
        op = o
        compress = c
        data = ByteBufUtil.getBytes(buf)
    }

    fun end(id: EventID_UDP) {
        op = id.op
        data = ByteBufUtil.getBytes(buf)
    }

    override fun toString(): String {
        val ID = if (udp) EventID_UDP.getEventIDByOp(op) else EventID.getEventIDByOp(op)
        return String.format(
            "%s, %s/0x%s\t| ", ID, op,
            Integer.toHexString(op).uppercase(Locale.getDefault())
        )
/*        return String.format(
            "%s, %s/0x%s\t| %s", ID, op,
            Integer.toHexString(op).uppercase(Locale.getDefault()),
            Util.readableByteArray(Arrays.copyOfRange(data, 0, data.size))
        )*/
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

    fun encodeTime(time: Int) {
        encodeInt(time)
    }
}
