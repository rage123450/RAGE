package util

import java.util.*

class Position {
    var x: Float
    var y: Float
    var z: Float

    constructor(x: Float, y: Float, z: Float) {
        this.x = x
        this.y = y
        this.z = z
    }

    constructor() {
        x = 0F
        y = 0F
        z = 0F
    }

    override fun toString(): String {
        return String.format("x: %d, y: %d", x, y)
    }

    fun deepCopy(): Position {
        return Position(x, y, z)
    }

    /**
     * Creates a Rect around this Position at its center.
     * Corners will be (pos.x + left, pos.y + top), (pos.x + right, pos.y + bottom)
     * @param rect The Rect around this Position
     * @return The newly created Rect
     */
    fun getRectAround(rect: Rect): Rect {
        val x = x
        val y = y
        return Rect(x + rect.left, y + rect.top, x + rect.right, y + rect.bottom)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val position = o as Position
        return x == position.x &&
                y == position.y
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y)
    }
}