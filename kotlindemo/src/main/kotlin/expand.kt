fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(1, 2)
    println(list)

//    val list2 = listOf(1,2,3)
    println(list.last)

    printlnShapeName(Rectangle())

    MyClass.test()

    BaseCaller().call(Base())   // “Base extension function in BaseCaller”
    DerivedCaller().call(Base())  // “Base extension function in DerivedCaller”——分发接收者虚拟解析
    DerivedCaller().call(Derived())  // “Base extension function in DerivedCaller”——分发接收者虚拟解析
}

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

open class Shape

class Rectangle : Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"

fun printlnShapeName(shape: Shape) {
    println(shape.getName())
}

val <T> List<T>.last
    get() = this[size - 1]

class MyClass {
    companion object {

    }
}

fun MyClass.Companion.test() {
    println("test")
}

open class Base

class Derived : Base()

open class BaseCaller {
    open fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunctionInfo()   // 调用扩展函数
    }
}

class DerivedCaller : BaseCaller() {
    override fun Base.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}



