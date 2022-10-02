package Netty

import UTF16LE
import UTF8
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import util.Position
import util.Rect
import util.Util
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.util.*

/**
 * Created on 2/18/2017.
 */
class InPacket(byteBuf: ByteBuf) {
    private val byteBuf: ByteBuf
    var udp = false
    var a = false
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
        val arr = ByteArray(size)
        if (byteBuf.readableBytes() >= size) byteBuf.readBytes(arr)
//        for (i in 0 until size) arr[i] = byteBuf.readByte()
        return arr
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

    fun decodeString(w: Boolean): String {
        val amount = decodeInt()
        try {
            val bytes = decodeArr(amount)
            return String(bytes, if (w) UTF16LE else UTF8)
        } catch (ex: UnsupportedEncodingException) {
            System.err.println(ex)
        }
        return ""
    }

    override fun toString(): String {
        return Util.readableByteArray(
            Arrays.copyOfRange(
                byteBuf.array(),
                byteBuf.array().size - byteBuf.readableBytes()/*byteBuf.array()!!.size - getLength()*/,
                if(udp) byteBuf.array().size else (if(a) 32 else 24) + length + (if(length > 0) 7 else 6)/*byteBuf.array()!!.size*/
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