import java.util.*
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {
    println(Direction.values().contentToString())
    println(Direction.valueOf("NORTH"))

    println("${Direction.NORTH.name} + ${Direction.NORTH.ordinal}")
}

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000)
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int {
            return t + u
        }
    },

    TIMES {
        override fun apply(t: Int, u: Int): Int {
            return u * u
        }
    }
    ;

    override fun applyAsInt(t: Int, u: Int): Int {
        return apply(t, u)
    }
}