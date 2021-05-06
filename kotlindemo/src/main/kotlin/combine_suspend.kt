import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
fun main() {
//    runBlocking {
//        val time = measureTime {
//            val one = async { doSomethingUsefulOne() }
//            val two = async { doSomethingUsefulTwo() }
//            println("The answer is ${one.await() + two.await()}")
//        }
//        println("Completed in $time ms")
//    }

    runBlocking {
        val time = measureTime {
            println("The answer is ${concurrentSum()}")
        }
        println("Completed in $time ms")
    }
}

suspend fun concurrentSum() : Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}

suspend fun doSomethingUsefulOne() : Int {
    println("${Thread.currentThread().name} doSomethingUsefulOne")
    delay(1000)
    println("${Thread.currentThread().name} doSomethingUsefulOne2")
    return 13
}

suspend fun doSomethingUsefulTwo() : Int {
    println("${Thread.currentThread().name} doSomethingUsefulTwo")
    delay(1000)
    println("${Thread.currentThread().name} doSomethingUsefulTwo2")
    return 29
}