import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() {
//    m1()

//    m2()

//    m3()

//    m4()

//    m5()

    runBlocking {
        val start = System.currentTimeMillis()
        val channel = ticker(100)
        launch {
            kotlin.repeat(10) {
                println("${System.currentTimeMillis() - start} ${channel.receive()}")
            }
        }
    }
}

private fun m5() {
    runBlocking {
        val channel = produceNumbers()
        launch(CoroutineName("c1")) {
            repeat(10) {
                println("$coroutineContext ${channel.receive()}")
            }
        }

        launch(CoroutineName("c2")) {
            repeat(10) {
                println("$coroutineContext ${channel.receive()}")
            }
        }

        println("Done")
        delay(3000)
        cancel()
    }
}

private fun m4() {
    runBlocking {
        var cur = numbersStartFrom(2)
        repeat(10) {
            val prime = cur.receive()
            println("prime is $prime")
            cur = filter(cur, prime)
        }
        println("Done")
        coroutineContext.cancelChildren()
    }
}

fun CoroutineScope.test() = iterator<Int> {  }

fun CoroutineScope.numbersStartFrom(start : Int) = produce<Int> {
    var i = start
    while (true) {
//        println("x = $i")
        send(i++)
    }
}

fun CoroutineScope.filter(channel: ReceiveChannel<Int>, prime : Int) = produce<Int> {
    for (x in channel) {
        if (x % prime != 0) {
            send(x)
        }
    }
}

private fun m3() {
    runBlocking {
        val numbers = produceNumbers()
        val squares = square(numbers)
        repeat(5) {
            println("receive ${squares.receive()}")
        }
        println("done")
//        cancel()
        coroutineContext.cancelChildren()
    }
}

fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    var i = 1
    while (true) {
        send(i++)
    }
}

 fun CoroutineScope.square(channel : ReceiveChannel<Int>) = produce<Int> {
    for (x in channel) {
        send(x * x)
    }
}
private fun m2() {
    runBlocking {
        val squares = produce<Int> {
            for (x in 1..5) {
                send(x * x)
            }
        }
        squares.consumeEach {
            println("$it")
        }
        println("Done")
    }
}

suspend fun produceSquares(): Channel<Int> {
    val channel = Channel<Int>()
    for (x in 1..5) {
        channel.send(x * x)
    }
    return channel
}

private fun m1() {
    val channel = Channel<Int>()
    runBlocking {
        launch {
            for (x in 1..5) {
                channel.send(x * x)
            }
        }

        repeat(5) {
            println("receive ${channel.receive()}")
        }
        println("Done")
    }
}