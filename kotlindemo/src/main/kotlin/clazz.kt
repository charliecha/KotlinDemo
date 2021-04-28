fun main() {
//    val person = Person("2", "3", 4)
//    println(person)
    println(Person.get())
    println(Person.get())
    println(Person.get())
}

class Person private constructor(firstName: String, secondName: String, age: Int) {
    val firstName: String
    val secondName: String
    val age: Int

    init {
        this.firstName = firstName
        this.secondName = secondName
        this.age = age
    }

//    override fun toString(): String {
//        return "$firstName $secondName $age"
//    }

    constructor(firstName: String, secondName: String) : this(firstName, secondName, 0)

    companion object {
        private var instance: Person? = null

        fun get(): Person {
            return instance ?: synchronized(this) {
                Person("1", "2", 3).apply {
                    instance = this
                }
            }
        }
    }
}