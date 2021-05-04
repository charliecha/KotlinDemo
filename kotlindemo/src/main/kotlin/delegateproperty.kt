import kotlin.properties.Delegates
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main() {
    val example = Example()
    example.p = "hello, world"
    println(example.p)

    println(lazyValue)
    println(lazyValue)

    val user22 = User22()
    user22.name = "first"
    user22.name = "second"
    println(user22.name)

    val myClass3 = MyClass3()
    myClass3.oldName = 10
    println(myClass3.newName)

    val map = mapOf("name" to "Joe", "age" to 23)
    val user1 = User1(map)
    println("${user1.name} ${user1.age}")

    println(
        delegate
    )
}

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating ${property.name} to me"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef")
    }
}

val lazyValue: String by lazy {
    println("computed")
    "hello"
}

class User22 {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("$property : $oldValue -> $newValue")
    }
}

class MyClass3 {
    var newName = 0
    var oldName: Int by this::newName
}

class User1(val map: Map<String, Any?>) {
    val name by map
    val age by map
}

class Foo

fun example(computeFoo: () -> Foo) {
    val memorizedFoo by lazy(computeFoo)
}

//class ResourceDelegate<T> : ReadOnlyProperty<MyUI, T> {
//    override fun getValue(thisRef: MyUI, property: KProperty<*>): T {
//        TODO("Not yet implemented")
//    }
//}
//
//class ResourceId<T> {
//
//}
//
//class ResourceLoader<T>(id: ResourceId<T>) {
//    operator fun provideDelegate(
//        thisRef: MyUI,
//        property: KProperty<*>
//    ): ReadOnlyProperty<MyUI, T> {
//        checkProperty(thisRef, property.name)
//        return ResourceDelegate()
//    }
//
//    private fun checkProperty(thisRef: MyUI, name: String) {
//
//    }
//}
//
//class MyUI {
//    fun <T> bindResource(id: ResourceId<T>): ResourceLoader<T> {
//
//    }
//
//    val image by bindResource(ResourceId.image_id)
//    val text by bindResource(ResourceId().text_id)
//}

val provider = PropertyDelegateProvider { thisRef: Any?, property: KProperty<*> ->
    ReadOnlyProperty<Any?, Int> { _, property ->
        42
    }
}

val delegate by provider


