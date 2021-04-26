import com.google.gson.Gson
import com.google.gson.JsonElement
import java.lang.Exception
import java.util.*

fun main() {
    val consumer1 = Consumer("cc1", "cc1@com")
    val consumer2 = Consumer("cc2", "cc2@com")
    val list = listOf(consumer2, consumer1)
    Collections.sort(list)
    println("list = $list")

    with(consumer1) {
        println(name)
    }
    consumer1.apply {
        println(name)
    }

    // 遍历map
    val map = mapOf<Int, Int>(1 to 1, 2 to 2)
    for ((k,v) in map) {
        println("$k -> $v")
    }

    // 延迟属性
    val p by lazy {
        consumer1.name
    }
    println(p.length)

    println("abc".array())

    println(Instance.name)

    val a : String? = null
    // if not null
    println(a?.length)
    println(a?.length ?: "empty")

    try {
        val b = a?.length ?: throw Exception("empty")
        println(b)
    } catch (e : Exception) {
        e.printStackTrace()
    }


    val b = a?.let {
        a.toUpperCase()
    } ?: "empty".toUpperCase()
    println(b)

}

// 泛型
inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

// 单例
object Instance{
    const val name = "cc"
}

// 拓展函数
fun String.array() : CharArray {
    return this.toCharArray()
}

// 数据类型
data class Consumer(val name: String, val email: String) : Comparable<Consumer> {
    override fun compareTo(other: Consumer): Int {
        return name.compareTo(other.name)
    }
}

