fun main() {
    val box = Box(1)
    println(box.value)
}

class Box<T>(t: T) {
    var value = t
}

interface Source<out T> {
    fun nextT() : T
}

fun demo(strs : Source<String>) {
    val objects : Source<Any> = strs
}

//interface Comparable<in T> {
//    operator fun compareTo(other : T) : Int
//}

fun demo(x : Comparable<Number>) {
    x.compareTo(1.0)
    val y : Comparable<Double> = x
}

fun <T : Comparable<T>> sort(list: List<T>) {

}