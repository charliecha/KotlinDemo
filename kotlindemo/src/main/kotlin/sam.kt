fun main() {
    runnable.run()
    runnable2.run()

    println("Is 8 even? - ${isEven.accept(8)}")
}

fun interface KRunnable {
    fun run()
}

val runnable = object : KRunnable {
    override fun run() {
        println("run1")
    }
}

val runnable2 = KRunnable {
    println("run2")
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }
