fun main() {
    val window = Window()
    window.addListener(object : Listener {
        override fun mouseClicked() {
            TODO("Not yet implemented")
        }

        override fun mouseEntered() {
            TODO("Not yet implemented")
        }
    })
}

class Outer {
    private val bar = 1

    inner class Nested {
        fun foo() = bar
    }
}

class Window {
    lateinit var listener: Listener

    fun addListener(listener: Listener) {
        this.listener = listener
    }
}

interface Listener {
    fun mouseClicked()
    fun mouseEntered()
}

