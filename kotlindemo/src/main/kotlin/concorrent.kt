import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis


var counter: Int = 0

var atomicCounter = AtomicInteger(0)
val counterContext = newSingleThreadContext("counterContext")
val mutex = Mutex()

sealed class CounterMsg
object IncCounter : CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

fun CoroutineScope.counterActor() = actor<CounterMsg> {
    var counter = 0
    for (msg in channel) {
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

fun main() {
    m2()

//    m1()
}

private fun m2() {
    runBlocking {
        val counter = counterActor()
        withContext(Dispatchers.Default) {
            massiveRun {
                counter.send(IncCounter)
            }
        }

        val response = CompletableDeferred<Int>()
        counter.send(GetCounter(response))
        println("Counter = ${response.await()}")
        counter.close()
    }
}

private fun m1() {
    runBlocking {
        withContext(Dispatchers.Default) {
            massiveRun {
                mutex.withLock {
                    counter++
                }
//                withContext(counterContext) {
//                    counter++
//                }
//                atomicCounter.addAndGet(1)
            }
        }
        println("Counter = $counter")
//        println("Counter = $atomicCounter")
    }
}

typealias Action = suspend () -> Unit

suspend fun massiveRun(action: Action) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        kotlinx.coroutines.coroutineScope {
            kotlin.repeat(n) {
                launch {
                    kotlin.repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("it takes $time ms.")
}