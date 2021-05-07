import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            flow()
                .collectLatest { value -> // 取消并重新发射最后一个值
                    println("Collecting1 $value")
                    delay(300) // 假装我们花费 300 毫秒来处理它
                    println("Done $value")
                }
        }
        println("Collected in $time ms")
    }

    runBlocking {
        flow2().collect {
            println("${Thread.currentThread().name} : $it")
        }
    }



    simple().forEach {
        value -> println("sequence $value")
    }

    runBlocking {
        flowOf(1,2,3).map { it * 2 }.collect { println("flow of $it") }

        launch {
            for (k in 1..3) {
                println("I'm not blocked $k")
                delay(100)
            }
        }

        flow().collect {
            println("flow1 $it")
        }

        flow().collect {
            println("flow2 $it")
        }
    }
}

fun flow2() : kotlinx.coroutines.flow.Flow<Int> = kotlinx.coroutines.flow.flow {
    for (i in 1..3) {
        kotlinx.coroutines.delay(100)
        emit(i)
    }
}.flowOn(Dispatchers.IO)

fun flow() : kotlinx.coroutines.flow.Flow<Int> = kotlinx.coroutines.flow.flow {
    for (i in 1..3) {
        kotlinx.coroutines.delay(100)
        emit(i)
    }
}

fun simple() : Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100)
        yield(i)
    }
}