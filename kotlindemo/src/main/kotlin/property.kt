fun main() {
    val property = Property()
    property.name = "jj"
    println(property.name)

    property.onCreate()
    println(property.testObject)
}

class Property {
    var name: String = "1"
        get() {
            return field
        }

        set(value) {
            field = value
        }

    lateinit var testObject: TestObject

    fun onCreate() {
        testObject = TestObject()
    }
}

class TestObject
