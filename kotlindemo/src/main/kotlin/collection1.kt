fun main() {
    // 映射
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })

    // 合拢
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    // 关联
    val numbers2 = listOf("one", "two", "three", "four")
    println(numbers2.associateWith { it.length })
    println(numbers2.associateBy { it.first().toUpperCase() })
    println(numbers2.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))
    println(numbers2.associate { name -> name.toUpperCase().let { it to it.length } })

    // 打平
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
    println(numberSets.flatMap { it.map { i -> double(i) } })

    //字符串
    println(numbers2.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    // 划分
    println(numbers2.partition { it.length > 4 })

    // 谓词
    println(numbers2.any())
    println(numbers2.any{it.length > 3})

    // 加减
    val plusList = numbers2 + "first"
    val minusList = numbers2 - listOf("three", "four")
    println("$plusList : $minusList")
    
    // 分组
    println(numbers2.groupBy { it.first().toUpperCase() })
}

fun double(i: Int) = i * 2