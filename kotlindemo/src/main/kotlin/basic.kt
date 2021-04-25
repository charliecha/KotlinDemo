import java.awt.Rectangle

const val PI = 3.14
var x = 0

fun area(r: Float): Double {
    return PI * r * r
}

fun incrementX() {
    x += 1
}

fun main() {
//    println("Hello world!")

    incrementX()
    println("x = $x")

    println("1 + 2 = ${sum(1, 2)}")
    println("radius = 3, area = ${area(3F)}")

    val list = listOf(1, 2, 3)
    var sum = 0
    for (i in list) {
        sum += i
    }
    println("sum = $sum")

    println("type of null is ${getType(null)}")
    println("type of 'abc' is ${getType("abc")}")

    val range = 1..5
    for (i in range) {
        println("index $i")
    }

    val list2 = listOf(1, 2, 3, 4, 5, 6)
    list2.filter { it % 2 == 0 }.map { it / 2 }.forEach {
        println("$it")
    }

    val rect = Rectangle(1, 2)
    println("rect is $rect")
}

fun getType(o: Any?): String {
    return when (o) {
        null -> "Null"
        is Int -> "Int"
        is Float -> "Float"
        is Double -> "Double"
        is Boolean -> "Bool"
        is Long -> "Long"
        is String -> "String"
        else -> "Other"
    }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}