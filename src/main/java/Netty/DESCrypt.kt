package Netty

import util.Util
import java.lang.System.arraycopy
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.Mac
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

const val HMAC_SIZE = 10

object DESCrypt {

    val DEFAULT_DES_KEY = byteArrayOf(
        0xC7.toByte(), 0xD8.toByte(), 0xC4.toByte(), 0xBF.toByte(), 0xB5.toByte(), 0xE9.toByte(), 0xC0.toByte(), 0xFD.toByte()
    )

    val DEFAULT_HMAC_KEY = byteArrayOf(
        0xC0.toByte(), 0xD3.toByte(), 0xBD.toByte(), 0xC3.toByte(), 0xB7.toByte(), 0xCE.toByte(), 0xB8.toByte(), 0xB8.toByte()
    )

    fun decrypt(key: ByteArray, iv: ByteArray, buffer: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("DES/CBC/NoPadding").apply {
            init(Cipher.DECRYPT_MODE, SecretKeyFactory.getInstance("DES").generateSecret(DESKeySpec(key)), IvParameterSpec(iv))
        }
        return cipher.doFinal(buffer)
    }

    fun encrypt(op: Int, packetnum: Int, buffer: ByteArray, compress: Boolean): ByteArray {
        return encrypt(op, DEFAULT_DES_KEY, DEFAULT_HMAC_KEY, ByteArray(2), packetnum, buffer, compress)
    }

    fun encrypt(op: Int, key: ByteArray, hmac: ByteArray, prefix: ByteArray, packetnum: Int, buffer: ByteArray, compress: Boolean): ByteArray {
        val iv = ByteArray(8) // 正服是隨機大小寫英文字母或特殊符號 八個一樣的
        SecureRandom().nextBytes(iv)

        val cipher = Cipher.getInstance("DES/CBC/NoPadding").apply {
            init(
                Cipher.ENCRYPT_MODE,
                SecretKeyFactory.getInstance("DES").generateSecret(DESKeySpec(key)),
                IvParameterSpec(iv)
            )
        }

        val aBuffer = byteArrayOf(
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
        )

        var datasize = 24 + 2 + 4 + (if (buffer.size > 0) 1 else 0) + buffer.size + 8
        datasize -= datasize % 8

        var data = ByteArray(datasize).apply {
            arraycopy(aBuffer, 0, this, 0, 24)
            arraycopy(Util.ShortToByteArray(op), 0, this, 24, 2)
            arraycopy(Util.IntToByteArray(buffer.size), 0, this, 26, 4)
            arraycopy(buffer, 0, this, if (buffer.size > 0) 31 else 30, buffer.size)
        }

        val readydata = ByteArray(2 + 4 + 8 + datasize).apply {
            arraycopy(prefix, 0, this, 0, 2)
            arraycopy(Util.IntToByteArrayLE(packetnum), 0, this, 2, 4)
            arraycopy(iv, 0, this, 6, 8)
            arraycopy(cipher.doFinal(data), 0, this, 14, datasize)
        }

        return ByteArray(4 + 4 + readydata.size + HMAC_SIZE).apply {
            arraycopy(Util.IntToByteArrayLE(size), 0, this, 0, 4)
            arraycopy(Util.IntToByteArrayLE(packetnum), 0, this, 4, 4)
            arraycopy(readydata, 0, this, 8, readydata.size)
            arraycopy(getHmacMD5Data(hmac, readydata), 0, this, 8 + readydata.size, HMAC_SIZE)
        }
    }

    fun getHmacMD5Data(key: ByteArray, data: ByteArray): ByteArray {
        val mac = Mac.getInstance("HmacMD5").apply {
            init(SecretKeySpec(key, "HmacMD5"))
            update(data)
        }
        return mac.doFinal()
    }
}