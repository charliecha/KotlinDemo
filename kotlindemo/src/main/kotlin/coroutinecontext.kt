import kotlinx.coroutines.*

fun main() {
    threadLocal()

//    coroutineScope()

//    repeat()

//    coroutineContext()

//    coroutine()
}

private fun threadLocal() {
    val threadLocal = ThreadLocal<String>()
    threadLocal.set("main")
    runBlocking {
        val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
            println("before current thread: ${Thread.currentThread().name}, thread local value: ${threadLocal.get()}")
            yield()
            println("after current thread: ${Thread.currentThread().name}, thread local value: ${threadLocal.get()}")
        }

        job.join()
        println("current thread: ${Thread.currentThread().name}, thread local value: ${threadLocal.get()}")
    }
}

private fun coroutineScope() {
    runBlocking {
        val activity = Activity()
        activity.doSomething()
        println("Launched coroutines")
        delay(1500L)
        println("Destroying activity!")
        activity.destroy()
        delay(1000)
    }
}

class Activity {
    private val mainScope = CoroutineScope(Dispatchers.IO)

    fun doSomething() {
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
    }

    fun destroy() {
        mainScope.cancel()
    }
}

private fun repeat() {
    runBlocking {
        val request = launch {
            repeat(3) { i ->
                launch {
                    delay((i + 1) * 200L)
                    println("Corountine $i is done")
                }
            }
//            async(CoroutineName("vv")) {  }
            println("request")
        }
        request.join()
        println("complete")
    }
}

private fun coroutine() {
    runBlocking {
        launch {
            println("I'm working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined I'm working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default + CoroutineName("test")) {
            println("Default I'm working in thread ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyOwnThread")) {
            println("MyOwnThread I'm working in thread ${Thread.currentThread().name}")
        }
    }
}

private fun coroutineContext() {
    newSingleThreadContext("ctx1").use { ctx1 ->
        newSingleThreadContext("ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                println("${ctx1[Job]} started in ctx1 ${Thread.currentThread().name}")
                withContext(ctx2) {
                    println("working in ctx2 ${Thread.currentThread().name}")
                }
                println("back to ctx1 ${Thread.currentThread().name}")
            }
        }
    }
}