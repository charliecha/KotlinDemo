
fun main() {
    val mouseAdapter = object : MouseAdapter2 {
        override fun mouseClicked() {
            println("mouseClicked")
        }

        override fun mouseEntered() {
            println("mouseEntered")
        }
    }

    mouseAdapter.mouseClicked()

    foo()
}

fun foo() {
    val adHoc = object {
        var x = 1
        var y = 2

        fun sqrt() : Double = kotlin.math.sqrt(0.0 + x * x + y * y)
    }

    println(adHoc.x + adHoc.y)
    println(adHoc.sqrt())
}

interface MouseAdapter2 {
    fun mouseClicked()
    fun mouseEntered()
}

object Instance2 {

}

class MyClass2 {
    companion object Factory {
        fun create() : MyClass2 = MyClass2()
    }
}
