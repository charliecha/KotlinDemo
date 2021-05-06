import javafx.application.Application
import javafx.application.Application.launch
import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking {
    repeat(100_000) { // 启动大量的协程
        launch {
            delay(5000L)
            print(".")
        }
    }
}

//fun main() = runBlocking { // this: CoroutineScope
//    launch {
//        delay(200L)
//        println("${Thread.currentThread().name} : Task from runBlocking")
//    }
//
//    val coroutineScope = coroutineScope { // 创建一个协程作用域
//        launch {
//            delay(500L)
//            println("${Thread.currentThread().name} : Task from nested launch")
//        }
//
//        delay(100L)
//        println("${Thread.currentThread().name} : Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
//    }
//
//    println("$coroutineScope")
//    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
//}

//fun main() {
////    m1()
//    runBlocking {
//        println("${Thread.currentThread().name}")
//        m4(this)
//    }
//}

private suspend fun m4(coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        delay(1000L)
        println("world-")
        println("${Thread.currentThread().name}")
    }

    println("hello,")
}

private suspend fun m3() {
    val job = GlobalScope.launch {
        delay(1000L)
        println("world")
        println("${Thread.currentThread().name}")
    }

    println("hello,")
    job.join()
}

private suspend fun m2() {
    val job = GlobalScope.launch {
        delay(1000L)
        println("world")
        println("${Thread.currentThread().name}")
    }

    println("hello,")
//    job.cancel()
//    Thread.sleep(2000L)
    delay(2000L)
}

private fun m1() {
    thread {
        println("haha")

    }

    val job = GlobalScope.launch {
        delay(1000L)
        println("world")
        println("${Thread.currentThread().name}")
    }

    println("hello,")
    job.cancel()
    Thread.sleep(2000L)
}