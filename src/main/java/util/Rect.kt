package util

import Netty.OutPacket

class Rect {
    /**
     * Top left x coord
     * @return
     */
    /**
     * Top left x coord
     * @param left
     */
    var left = 0F
    /**
     * Top left y coord
     * @return
     */
    /**
     * Top left y coord
     * @param top
     */
    var top = 0F
    /**
     * Bottom right x coord
     * @return
     */
    /**
     * Bottom right x coord
     * @param right
     */
    var right = 0F
    /**
     * Bottom right y coord
     * @return
     */
    /**
     * Bottom right y coord
     * @param bottom
     */
    var bottom = 0F

    constructor() {}
    constructor(left: Float, top: Float, right: Float, bottom: Float) {
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }

    constructor(lt: Position, rb: Position) {
        left = lt.x
        top = lt.y
        right = rb.x
        bottom = rb.y
    }

    /**
     * Returns the width of this Rect.
     * @return the width of this Rect.
     */
    val width: Float
        get() = Math.abs(left - right)

    /**
     * Returns the height of this Rect.
     * @return The height of this Rect.
     */
    val height: Float
        get() = Math.abs(top - bottom)

    /**
     * Encodes this Rect to a given [OutPacket].
     * @param outPacket The OutPacket this Rect should be encoded to.
     */
    fun encode(outPacket: OutPacket) {
        outPacket.encodeFloat(left)
        outPacket.encodeFloat(top)
        outPacket.encodeFloat(right)
        outPacket.encodeFloat(bottom)
    }

    /**
     * Returns whether or not a [Position] is inside this Rect.
     * @param position The Position to check.
     * @return if the position is not null and inside this Rect (rect.left < pos.x < rect.right &&
     * rect.top < pos.y < rect.bottom.
     */
    fun hasPositionInside(position: Position?): Boolean {
        if (position == null) {
            return false
        }
        val x = position.x
        val y = position.y
        return x >= left && y >= top && x <= right && y <= bottom
    }

    /**
     * Move this Rect left by the width, effectively flipping around the left edge.
     * @return The resulting Rect from the move.
     */
    fun moveLeft(): Rect {
        return Rect(left - width, top, left, bottom)
    }

    /**
     * Move this Rect right by the width, effectively flipping around the right edge.
     * @return The resulting Rect from the move.
     */
    fun moveRight(): Rect {
        return Rect(right, top, right + width, bottom)
    }

    /**
     * Flips this Rect horizontally around a certain Position's x .
     * @param x The x to flip around
     * @return The flipped Rect
     */
    fun horizontalFlipAround(x: Int): Rect {
        return Rect(right - 2 * (right - x), top, left + 2 * (x - left), bottom)
    }

    /**
     * Returns a deep copy of this Rect.
     * @return a deep copy of this Rect
     */
    fun deepCopy(): Rect {
        return Rect(left, top, right, bottom)
    }

    override fun toString(): String {
        return "Rect{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                '}'
    }

    /**
     * Returns a random Position that is inside this Rect.
     * @return the random Position
     */
    val randomPositionInside: Position
        get() {
            val randX = Util.getRandom(left.toInt(), right.toInt()).toFloat()
            val randY = Util.getRandom(top.toInt(), bottom.toInt()).toFloat()
            return Position(randX, randY, 0F)
        }
}