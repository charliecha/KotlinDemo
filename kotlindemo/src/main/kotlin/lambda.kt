fun main() {
    val list = listOf(1, 2, 3)

    val size = list::size
    println("${size()}")

    val size2 = List<Int>::size
    println("${size2(list)}")

//    val fold2 = Collection<Int, String>::fold

    val result = list.fold("result:") { acc: Int, nextElement: String ->
        "$nextElement $acc"
    }
    println(result)

    val f = IntTransformer()
    println("transform 1 is ${f(1)}")

    println("sum of list is ${list.fold(0) { acc: Int, i: Int -> acc + i }}")

    val body2 = Html::body
    val html = html {
        println(this)
        this.body()
    }
}

class IntTransformer : (Int) -> Int {
    override fun invoke(p1: Int): Int {
        return p1 + 1
    }
}

fun <T, R> Collection<T>.fold(initial: R, combine: (acc: T, nextElement: R) -> R): R {
    var result = initial
    for (v in this) {
        result = combine(v, result)
    }
    return result
}

class Html {
    init {
        println("html")
    }

    fun body() {
        println("body")
    }
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}