import org.reduxkotlin.compose
import java.util.*
import kotlin.math.acos

fun main() {
//    println("hello, world")

//    val date = Date(2020, 6, 12)
//    println(date.time)

    val calendar = Calendar.getInstance()
    var now = calendar.time

    calendar.set(2020, 6, 12, 0, 0, 0)

    val sunday = calendar.time

    println(sunday.time)
    println(now.time - sunday.time)
    println(System.currentTimeMillis())

    val f1: (((Int) -> Int)) -> (Int) -> Int = fun(next: (((Int) -> Int))): (action: Int) -> Int {
        return fun(action: Int): Int {
            println("before f1 action ${action}")
            val action = next(action)
            println("after f1 action ${action}")
            return action
        }
    }

    val f2: (((Int) -> Int)) -> (Int) -> Int = fun(next: (((Int) -> Int))): (action: Int) -> Int {
        return fun(action: Int): Int {
            println("before f2 action ${action}")
            val action = next(action)
            println("after f2 action ${action}")
            return action
        }
    }

//    println(f(1)(2))

    val dispatcher = fun(i: Int): Int {
        return i * i
    }

    val list = compose(f1, f2)(dispatcher)(3)
//    println(f(1))
//    println(f2(1))
//    println(list)
}

