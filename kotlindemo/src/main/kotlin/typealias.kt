fun main() {
    val f : (Int) -> Boolean = {it > 0}
    println(foo(f))

    val p : Predicate<Int> = {it > 0}
    println(foo(p))
    println(listOf(1, -2).filter(p))
}

typealias Predicate<T> = (T) -> Boolean

fun foo(p : Predicate<Int>) = p(42)