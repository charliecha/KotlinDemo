fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.drop(1))

    println(numbers.chunked(3))

    println(numbers.windowed(3))

    println(numbers.random())

    println(numbers.sorted())
    println(numbers.shuffled())

    val numbers2 = listOf(1, 2, 3, 4, 5, 6)
    println(numbers2.fold(0) { acc, nextElement ->
        acc + nextElement
    })
    println(numbers2.reduce { acc, i -> acc + i })

    val numbers3 = numbers2.toMutableList()
    numbers3.removeAll { it < 3 }
    println(numbers3)
    numbers3.retainAll { it % 2 == 0 }
    println(numbers3)

    val sorted = numbers2.toMutableList()
    sorted.sort()
    println(sorted.binarySearch(2))
    println(sorted.binarySearch{
        it - 2
    })
}