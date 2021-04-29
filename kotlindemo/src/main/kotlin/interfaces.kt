
interface MyInterface {
    val prop: Int

    val propWithImplements: String
        get() = "foo"

    fun bar()

    fun foo() {
        println("foo")
    }
}

class Child(override val prop: Int) : MyInterface {
//    override val prop: Int
//        get() = 1

    override fun bar() {
        println("")
    }
}

interface Name {
    val name: String
}

interface Person2 : Name {
    val firstName: String
    val lastName: String
    override val name: String
        get() = "$firstName $lastName"
}

class Employee(override val firstName: String, override val lastName: String) : Person2

interface A {
    fun  foo()
    fun bar() {}
}

interface B {
    fun foo() {}
    fun bar() {}
}

class C : A, B {
    override fun foo() {
        super<B>.foo()
    }

    override fun bar() {
        super<A>.bar()
        super<B>.bar()
    }
}

