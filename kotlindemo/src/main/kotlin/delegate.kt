fun main() {
    val b = BaseImpl2(2)
    Derived2(b).print()
}

interface Base2{
    fun print()
}

class BaseImpl2(val x : Int) : Base2 {
    override fun print() {
        print(x)
    }
}

class Derived2(val b : Base2) : Base2 by b {
    override fun print() {
        println("Derived2 ")
        b.print()
    }
}
