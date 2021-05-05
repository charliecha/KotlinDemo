import kotlin.math.max

fun main() {
    val bytes = arrayOf(1.toByte(), 2.toByte(), 3.toByte())
    read(bytes, len = 2)

    foo(bar = 1, baz = 2) {
        println("hello, world")
    }

    test(x = 1, y = 2)

    val list = asList(1, 2, 3)
    println(list)

    1 shl 2

    println("fib(10) = ${fib(10)}")
}

fun max3(x : Int, y : Int, z : Int) : Int {
    fun max2(x : Int, y : Int) : Int {
        return max(x, y)
    }

    return max2(max2(x, y), z)
}

fun <T> asList(vararg ts : T) : List<T> {
    val result = mutableListOf<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

infix fun Int.shl(x: Int) : Int{
    return 0
}

fun test(x : Int, y : Int) {
    println("$x $y")
}

fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
    for (i in off until len) {
        println(b[i])
    }
}

fun foo(bar : Int = 0, baz : Int =1, qux : () -> Unit) {
    qux()
}

tailrec fun fib(i : Int) : Int {
    return when(i) {
        1,2 -> 1
        else -> fib(i -1 ) + fib(i - 2)
    }
}