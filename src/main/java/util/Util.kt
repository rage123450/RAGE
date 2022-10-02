package util

import io.netty.buffer.ByteBuf
import java.io.*
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.NumberFormat
import java.util.*
import java.util.function.Predicate
import java.util.regex.Pattern
import java.util.stream.IntStream
import java.util.zip.Deflater
import java.util.zip.Inflater


/**
 * Created on 2/28/2017.
 */
object Util {
    private val boxedToPrimClasses: MutableMap<Class<*>, Class<*>?> = HashMap()
    private val regexPattern = Pattern.compile("^\\$2[a-z]\\$.{56}$")

    /**
     * Gets a random element from a given List. This is done by utilizing [.getRandom].
     * @param list The list to select the element from
     * @param <T> The type of elements of the list
     * @return A random element from the list, or null if the list is null or empty.
    </T> */
    fun <T> getRandomFromCollection(list: List<T>?): T? {
        return if (list != null && list.size > 0) {
            list[getRandom(list.size - 1)]
        } else null
    }

    /**
     * Gets a random element from a given Collection. This is done by making an array from the Collection and calling
     * [.getRandomFromCollection]
     * @param coll The collection to select the element from
     * @param <T> The type of elements of the list
     * @return A random element from the list, or null if the list is null or empty.
    </T> */
    fun <T> getRandomFromCollection(coll: Collection<T>?): T {
        return getRandomFromCollection(ArrayList(coll))!!
    }

    /**
     * Gets a random element from a given List. This is done by utilizing [.getRandom].
     * @param list The list to select the element from
     * @param <T> The type of elements of the list
     * @return A random element from the list, or null if the list is null or empty.
    </T> */
    fun <T> getRandomFromCollection(list: Array<T>?): T? {
        return if (list != null && list.size > 0) {
            list[getRandom(list.size - 1)]
        } else null
    }

    /**
     * Reads a file and returns the contents as a single String.
     * @param path The path to the file
     * @param encoding The encoding the file is in.
     * @return The contents of the File as a single String.
     * @throws IOException If the file cannot be found (usually)
     */
    @Throws(IOException::class)
    fun readFile(path: String?, encoding: Charset?): String {
        val encoded = Files.readAllBytes(Paths.get(path))
        return String(encoded, encoding!!)
    }

    /**
     * Creates a writes to a file with given directory path.
     * Will overwrite any pre-existing file.
     *
     * @param path path to the file
     * @param content content of new file. Each string in content is on a new line
     * @throws IOException if file already exists and is currently in use
     */
    @Throws(IOException::class)
    fun createAndWriteToFile(path: String?, content: List<String>) {
        BufferedWriter(OutputStreamWriter(
            FileOutputStream(path), StandardCharsets.UTF_8)).use { writer ->
            for (line in content) {
                writer.write("""
    $line
    
    """.trimIndent())
            }
        }
    }

    /**
     * Returns a bitwise OR of two arrays. Takes the length of arr1 as the return array size. If arr2 is smaller,
     * will return an [ArrayIndexOutOfBoundsException].
     * @param arr1 The first array
     * @param arr2 The second array
     * @return The result of using bitwise OR on all contents of arr1 to arr2 such that for all index i with i < arr1.length:
     * res[i] == arr1[i] | arr2[i]
     */
    fun bitwiseOr(arr1: IntArray, arr2: IntArray): IntArray {
        val res = IntArray(arr1.size)
        for (i in res.indices) {
            res[i] = arr1[i] or arr2[i]
        }
        return res
    }

    /**
     * Returns the current time as an int. See System.currentTimeMillis().
     * @return the current time as an int.
     */
    val currentTime: Int
        get() = System.currentTimeMillis().toInt()

    /**
     * Returns the current time. Simply calls System.currentTimeMillis().
     * @return The current time as milliseconds since unix start time
     */
    val currentTimeLong: Long
        get() = System.currentTimeMillis()

    val currentTimeString: String
        get() = System.currentTimeMillis().toString()

    /**
     * Returns a random number from 0 up to (and **including**) inclBound. Creates a new Random class upon call.
     * If a bound smaller or equal to 0 is given, always returns 0.
     * @param inclBound the upper bound of the random number
     * @return A random number from 0 up to and including inclBound
     */
    fun getRandom(inclBound: Int): Int {
        return if (inclBound <= 0) {
            0
        } else Random().nextInt(inclBound + 1)
    }

    /**
     * Returns a random number from `start` up to `end`. Creates a new Random class upon call.
     * If `start` is greater than `end`, `start` will be swapped with `end`.
     * @param start the lower bound of the random number
     * @param end the upper bound of the random number
     * @return A random number from `start` up to `end`
     */
    fun getRandom(start: Int, end: Int): Int {
        var start = start
        var end = end
        if (end - start == 0) {
            return start
        }
        if (start > end) {
            val temp = end
            end = start
            start = temp
        }
        return start + Random().nextInt(end - start)
    }
    /**
     * Checks if some action succeeds, given a chance and maximum number.
     * @param chance The threshold at which something is classified as success
     * @param max The maximum number that is generated, exclusive
     * @return Whether or not the test succeeded
     */
    /**
     * Checks of some action succeeds, given a chance out of a 100.
     * @param chance The threshold at which something is classified as success
     * @return Whether or not the test succeeded
     */
    @JvmOverloads
    fun succeedProp(chance: Int, max: Int = 100): Boolean {
        val random = Random()
        return random.nextInt(max) < chance
    }
    // https://www.programcreek.com/2014/03/leetcode-reverse-bits-java/
    /**
     * Reverses all the bits of an integer.
     * @param n The number to reverse the bits of
     * @return The reversed bits
     */
    fun reverseBits(n: Int): Int {
        var n = n
        for (i in 0..15) {
            n = swapBits(n, i, 32 - i - 1)
        }
        return n
    }

    /**
     * Swaps two bits of a given number.
     * @param n The number that the bits should be swapped of
     * @param i The first swapping index
     * @param j The second swapping index
     * @return The number with the bits reversed
     */
    private fun swapBits(n: Int, i: Int, j: Int): Int {
        var n = n
        val a = n shr i and 1
        val b = n shr j and 1
        if (a xor b != 0) {
            n = n xor (1 shl i or (1 shl j))
        }
        return n
    }

    /**
     * Checks if a String is a number ((negative) natural or decimal).
     * @param string The String to check
     * @return Whether or not the String is a number
     */
    fun isNumber(string: String?): Boolean {
        return string != null && string.matches("-?\\d+(\\.\\d+)?".toRegex())
    }

    /**
     * Creates a byte array given a string. Ignores spaces and the '|' character.
     * @param s The String to transform
     * @return The byte array that the String contained (if there is any, some RuntimeException otherwise)
     */
    fun getByteArrayByString(s: String): ByteArray {
        var s = s
        s = s.replace("|", " ")
        s = s.replace(" ", "")
        val len = s.length
        val data = ByteArray(len / 2)
        var i = 0
        while (i < len) {
            data[i / 2] = ((s[i].digitToIntOrNull(16) ?: -1 shl 4)
            + s[i + 1].digitToIntOrNull(16)!! ?: -1).toByte()
            i += 2
        }
        return data
    }

    /**
     * Turns a byte array into a readable String (e.g., 3A 00 89 BF).
     * @param arr The array to transform
     * @return The readable byte array
     */
    fun readableByteArray(arr: ByteArray): String {
        val res = StringBuilder()
        for (b in arr) {
            res.append(String.format("%02X ", b))
        }
        return res.toString()
    }

    /**
     * Turns a ByteBuf into a readable String (e.g., 3A 00 89 BF).
     * @param buf The ByteBuf to transform
     * @return The readable byte array
     */
    fun readableByteArrayFromByteBuf(buf: ByteBuf): String {
        val bytes = ByteArray(buf.capacity())
        for (i in buf.readableBytes() until buf.capacity()) {
            bytes[i] = buf.getByte(i)
        }
        return readableByteArray(bytes)
    }

    fun ShortToByteArray(n: Int): ByteArray {
        val res = ByteArray(Integer.BYTES)
        res[0] = (n ushr 8).toByte()
        res[1] = n.toByte()
        return res
    }

    fun ShortToByteArrayLE(n: Int): ByteArray {
        val res = ByteArray(Integer.BYTES)
        res[0] = n.toByte()
        res[1] = (n ushr 8).toByte()
        return res
    }

    fun IntToByteArray(n: Int): ByteArray {
        val res = ByteArray(Integer.BYTES)
        res[0] = (n ushr 24).toByte()
        res[1] = (n ushr 16).toByte()
        res[2] = (n ushr 8).toByte()
        res[3] = n.toByte()
        return res
    }

    /**
     * Transforms an integer into a byte array of length 4, Little Endian.
     * @param n The number to turn into a byte array
     * @return The created byte array (Little Endian)
     */
    fun IntToByteArrayLE(n: Int): ByteArray {
        val res = ByteArray(Integer.BYTES)
        res[0] = n.toByte()
        res[1] = (n ushr 8).toByte()
        res[2] = (n ushr 16).toByte()
        res[3] = (n ushr 24).toByte()
        return res
    }

    /**
     * Creates a directory if there is none.
     * @param dir The directory to create
     */
    fun makeDirIfAbsent(dir: String?) {
        val file = File(dir)
        if (!file.exists()) {
            file.mkdir()
        }
    }

    /**
     * Adds right padding given an initial String, padding character and maximum length. If the input String is longer
     * than the given maximum length, the String length is taken instead (effectively doing nothing, as there is
     * nothing to pad.
     * @param totalLength The total length the String should amount to
     * @param c The padding character
     * @param value The initial value of the String
     * @return The right padded String
     */
    fun rightPaddedString(totalLength: Int, c: Char, value: String): String {
        var totalLength = totalLength
        totalLength = Math.max(totalLength, value.length)
        val chars = CharArray(totalLength)
        val valueChars = value.toCharArray()
        for (i in 0 until value.length) {
            chars[i] = valueChars[i]
        }
        for (i in value.length until chars.size) {
            chars[i] = c
        }
        return String(chars)
    }

    /**
     * Adds left padding given an initial String, padding character and maximum length. If the input String is longer
     * than the given maximum length, the String length is taken instead (effectively doing nothing, as there is
     * nothing to pad.
     * @param totalLength The total length the String should amount to
     * @param c The padding character
     * @param value The initial value of the String
     * @return The left padded String
     */
    fun leftPaddedString(totalLength: Int, c: Char, value: String): String {
        var totalLength = totalLength
        totalLength = Math.max(totalLength, value.length)
        val chars = CharArray(totalLength)
        val valueChars = value.toCharArray()
        val pad = totalLength - value.length
        var i: Int
        i = 0
        while (i < pad) {
            chars[i] = c
            i++
        }
        var j = 0
        i = pad
        while (i < chars.size) {
            chars[i] = valueChars[j++]
            i++
        }
        return String(chars)
    }

    /**
     * Gets a single element from a collection by using a predicate. Returns a random element if there are multiple
     * elements for which the predicate holds.
     * @param collection The collection the element should be gathered from
     * @param pred The predicate that should hold for the element
     * @param <T> The type of the collection's elements
     * @return An element for which the predicate holds, or null if there is none
    </T> */
    fun <T> findWithPred(collection: Collection<T?>, pred: Predicate<T?>?): T? {
        return collection.stream().filter(pred).findAny().orElse(null)
    }

    /**
     * Gets a single element from an array by using a predicate. Returns a random element if there are multiple
     * elements for which the predicate holds.
     * @param arr The array the element should be gathered from
     * @param pred The predicate that should hold for the element
     * @param <T> The type of the collection's elements
     * @return An element for which the predicate holds, or null if there is none
    </T> */
    fun <T> findWithPred(arr: Array<T>, pred: Predicate<T?>?): T? {
        return findWithPred(Arrays.asList(*arr), pred)
    }

    /**
     * Returns a formatted number, using English locale.
     *
     * @param number The number to be formatted
     * @return The formatted number
     */
    fun formatNumber(number: String): String {
        return NumberFormat.getInstance(Locale.ENGLISH).format(number.toLong())
    }

    fun convertBoxedToPrimitiveClass(clazz: Class<*>): Class<*>? {
        return boxedToPrimClasses.getOrDefault(clazz, clazz)
    }

    /**
     * Tells us if a string is a BCrypt hash.
     *
     * @param password Password to check
     * @return Boolean value
     */
    fun isStringBCrypt(password: String?): Boolean {
        return regexPattern.matcher(password).matches()
    }

    /**
     * Returns the long as an int, or Integer.MAX_VALUE if it exceeds the maximum int value.
     * @param num the number that should be capped at Integer.MAX_VALUE
     * @return `num` if the number is small enough, else Integer.MAX_VALUE
     */
    fun maxInt(num: Long): Int {
        return Math.min(Int.MAX_VALUE.toLong(), num).toInt()
    }

    /**
     * Creates a Set of given elements.
     * @param elems a list of elements
     * @param <T> the type of the elements
     * @return a new Set created from the elements
    </T> */
    fun <T> makeSet(vararg elems: T): Set<T> {
        val set: MutableSet<T> = HashSet()
        for (elem in elems) {
            set.add(elem)
        }
        return set
    }

    /**
     * Checks if a String is purely made out of digits and/or letters.
     * @param str the String to check
     * @return if the String only contains digits and/or letters
     */
    fun isDigitLetterString(str: String?): Boolean {
        return str != null && str.matches("[a-zA-Z0-9]+".toRegex()) // maybe allow special characters?
    }

    /**
     * Checks if a String is valid enough that it won't crash other users.
     * @param str the String to check
     * @return whether or not the String is valid
     */
    fun isValidString(str: String?): Boolean {
        return str != null && str.matches("[a-zA-Z0-9`~!@#$%^&*()_+-={}|\\\\;':\",./<>?]*".toRegex())
    }

    /**
     * Checks if a String is an int.
     * @param val the String to check
     * @return whether or not the String is an int
     */
    fun isInteger(`val`: String?): Boolean {
        if (`val` != null && `val`.matches("^-?[0-9]+".toRegex()) && `val`.length <= 10) {
            val longVal = `val`.toLong()
            return longVal >= Int.MIN_VALUE && longVal <= Int.MAX_VALUE
        }
        return false
    }

    /**
     * Rotates a given value by a certain amount left.
     * @param value the value to rotate
     * @param rotateAmount the amount to rotate
     * @return the rotated value
     */
    fun rotateLeft(value: Int, rotateAmount: Byte): Int {
        return value shl rotateAmount.toInt() or (value ushr 32 - rotateAmount)
    }

    /**
     * Creates an int from a byte array of length >= 4, Big Endian.
     * @param arr the arr to convert
     * @return the BE int from the array
     */
    fun toInt(arr: ByteArray): Int {
        return arr[0].toInt() shl 24 or (arr[1].toInt() shl 16) or (arr[2].toInt() shl 8) or (arr[3].toInt())
    }

    /**
     * Checks whether or not a raw int array contains a value.
     * @param arr the array to check the value
     * @param checkVal the value to look for
     * @return whether or not the array contains the value
     */
    fun arrayContains(arr: IntArray, checkVal: Int): Boolean {
        return IntStream.of(*arr).anyMatch { `val`: Int -> `val` == checkVal }
    }

    /**
     * Searches through the given directory recursively to find all files
     * @param toAdd the set to add the files to
     * @param dir the directory to start in
     */
    fun findAllFilesInDirectory(toAdd: MutableSet<File?>, dir: File?) {
        // depth first search
        if (dir != null) {
            if (dir.isDirectory) {
                for (file in Objects.requireNonNull(dir.listFiles())) {
                    if (file.isDirectory) {
                        findAllFilesInDirectory(toAdd, file)
                    } else {
                        toAdd.add(file)
                    }
                }
            }
        }
    }

    /**
     * Compute the SHA-1 hash of the bytes in the given buffer
     * @param toHash ByteBuffer
     * @return byte[]
     */
    fun sha1Hash(toHash: ByteArray?): ByteArray? {
        return try {
            val crypt = MessageDigest.getInstance("SHA-1")
            crypt.update(toHash)
            crypt.digest()
        } catch (nsae: NoSuchAlgorithmException) {
            null
        }
    }

    fun compress(data: ByteArray): ByteArray {
        val c = Deflater()
        c.setInput(data)
        c.finish()
        val buf = ByteArray(2000)
        val count = c.deflate(buf)
        c.end()
        return buf.copyOfRange(0, count)
    }

    fun uncompress(data: ByteArray): ByteArray {
        val uc = Inflater()
        uc.setInput(data)
        val buf = ByteArray(2000)
        val count = uc.inflate(buf)
        uc.end()
        return buf.copyOfRange(0, count)
    }

/*    fun compress(data: ByteArray): ByteArray {
        val compresser = Deflater()
        compresser.reset()
        compresser.setInput(data)
        compresser.finish()
        val bos = ByteArrayOutputStream(data.size)
        val buf = ByteArray(2000)
        while (!compresser.finished()) {
            val i = compresser.deflate(buf)
            bos.write(buf, 0, i)
        }
        val output = bos.toByteArray()
        compresser.end()
        return output
    }

    fun uncompress(data: ByteArray): ByteArray {
        val decompresser = Inflater()
        decompresser.reset()
        decompresser.setInput(data)
        val o = ByteArrayOutputStream(data.size)
        val buf = ByteArray(2000)
        while (!decompresser.finished()) {
            val i = decompresser.inflate(buf)
            o.write(buf, 0, i)
        }
        val output = o.toByteArray()
        decompresser.end()
        return output
    }*/

    init {
        boxedToPrimClasses[Boolean::class.java] = Boolean::class.javaPrimitiveType
        boxedToPrimClasses[Byte::class.java] = Byte::class.javaPrimitiveType
        boxedToPrimClasses[Short::class.java] = Short::class.javaPrimitiveType
        boxedToPrimClasses[Char::class.java] = Char::class.javaPrimitiveType
        boxedToPrimClasses[Int::class.java] = Int::class.javaPrimitiveType
        boxedToPrimClasses[Long::class.java] = Long::class.javaPrimitiveType
        boxedToPrimClasses[Float::class.java] = Float::class.javaPrimitiveType
        boxedToPrimClasses[Double::class.java] = Double::class.javaPrimitiveType
    }
}