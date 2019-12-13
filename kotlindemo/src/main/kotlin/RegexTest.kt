import com.google.gson.Gson

fun main() {
    test()
}

fun test() {
    var map = HashMap<String, String>()
    map["com.taobao.taobao"] = "€[a-z0-9A-Z]{11}€"
    map["com.xunmeng.pinduoduo"] = "[a-z0-9A-Z]{16}"

    val gson = Gson()

    val json = gson.toJson(map)
    println(json)

    val map2 = gson.fromJson(json, Map::class.java)
    println(map2)


}