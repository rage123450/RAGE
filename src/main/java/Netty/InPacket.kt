package Netty

import UTF16LE
import UTF8
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import util.Position
import util.Rect
import util.Util
import java.io.UnsupportedEncodingException
import java.util.*

class InPacket(byteBuf: ByteBuf) {
    private val byteBuf: ByteBuf
    var udp = false
    var SerializeHelperSize = 0
    var header = 0
    var length = 0
    var compress = false

    /**
     * Creates a new InPacket with no data.
     */
    /*    public InPacket(){
        this(Unpooled.buffer());
    }*/
    /**
     * Creates a new InPacket with given data.
     * @param data The data this InPacket has to be initialized with.
     */
    constructor(data: ByteArray?) : this(Unpooled.copiedBuffer(data)) {
    }

    constructor(data: ByteArray?, u: Boolean) : this(Unpooled.copiedBuffer(data)) {
        udp = u
    }

    /*    fun getData(): ByteArray {
            return byteBuf.array()
        }

        fun clone(): InPacket {
            return InPacket(byteBuf)
        }*/

    /**
     * Reads a single byte of the ByteBuf.
     * @return The byte that has been read.
     */
    fun decodeByte(): Byte {
        return byteBuf.readByte()
    }

    fun decodeUByte(): Short {
        return byteBuf.readUnsignedByte()
    }

    fun decodeBoolean(): Boolean {
        return byteBuf.readBoolean()
    }

    /**
     * Reads an `amount` of bytes from the ByteBuf.
     * @param amount The amount of bytes to read.
     * @return The bytes that have been read.
     */
    fun decodeArr(size: Int): ByteArray {
        if (byteBuf.readableBytes() >= size) {
            val arr = ByteArray(size)
            byteBuf.readBytes(arr)
            return arr
        } else {
            return ByteArray(0)
        }
    }

    /**
     * Reads an integer from the ByteBuf.
     * @return The integer that has been read.
     */
    fun decodeInt(): Int {
        return byteBuf.readInt()
    }

    /**
     * Reads a short from the ByteBuf.
     * @return The short that has been read.
     */
    fun decodeShort(): Short {
        return byteBuf.readShort()
    }

    fun decodeFloat(): Float {
        return byteBuf.readFloat()
    }

    fun decodeDouble(): Double {
        return byteBuf.readDouble()
    }

    fun decodeString() = decodeString(true)

    fun decodeString(wstr: Boolean): String {
        val amount = decodeInt()
        if (byteBuf.readableBytes() < amount) {
            System.err.println("decodeString 可讀字節不夠")
            return ""
        }
        try {
            val bytes = decodeArr(amount)
            return String(bytes, if (wstr) UTF16LE else UTF8)
        } catch (ex: UnsupportedEncodingException) {
            System.err.println(ex)
        }
        return ""
    }

    override fun toString(): String {
        val offset = SerializeHelperSize * 8
        return Util.readableByteArray(
            Arrays.copyOfRange(
                byteBuf.array(),
                byteBuf.array().size - byteBuf.readableBytes()/*byteBuf.array()!!.size - getLength()*/,
                if (udp) byteBuf.array().size else (24 + offset) + length + (if (length > 0) 7 else 6)/*byteBuf.array()!!.size*/
            )
        ) // Substring after copy of range xd
    }

    /**
     * Reads and returns a long from this net.swordie.ms.connection.packet.
     * @return The long that has been read.
     */
    fun decodeLong(): Long {
        return byteBuf.readLong()
    }

    fun decodeLongLE(): Long {
        return byteBuf.readLongLE()
    }

    /**
     * Reads a position (short x, short y) and returns this.
     * @return The position that has been read.
     */
    fun decodePosition(): Position {
        return Position(decodeFloat(), decodeFloat(), decodeFloat())
    }

    /**
     * Reads a rectangle (short l, short t, short r, short b) and returns this.
     * @return The rectangle that has been read.
     */
    fun decodeRect(): Rect {
        return Rect(decodePosition(), decodePosition())
    }

    fun release() {
        byteBuf.release()
    }

    /**
     * Creates a new InPacket with a given buffer.
     * @param byteBuf The buffer this InPacket has to be initialized with.
     */
    init {
        this.byteBuf = byteBuf.copy()
    }
}