fun main() {
    val user = User("cc", 10)
    println(user)

    val user2 = user.copy(name = "cc2")

    val (name, age) = user2
    println("$name $age")

    val user3 = User2("ss", 11)
    println(user3)
    val (name2, age2) = user3
    println("$name2 $age2")
}

data class User(val name: String, val age: Int)

class User2(private val name: String, private val age: Int) {
    operator fun component1() = name
    operator fun component2() = age

    override fun toString(): String {
        return "$name $age"
    }

    fun copy() : User2 {
        return User2(this.name, this.age)
    }
}