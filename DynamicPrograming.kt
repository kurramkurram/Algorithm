// https://qiita.com/square1001/items/6d414167ca95c97bd8b2#%E5%8B%95%E7%9A%84%E8%A8%88%E7%94%BB%E6%B3%95%E3%81%AE%E7%99%BB%E5%A0%B4
fun main() {
    val n = 40
    val card = listOf(1, 3, 5, 11)
    val ret = dp(n, card)
    println(ret)
}

fun dp(n: Int, card: List<Int>): Int {
    val list = MutableList(n + 1) { 0 }
    for (i in 1 until list.size) {
        var before = n
        card.forEach {
            val index = i - it
            if (index >= 0 && list[index] < before) {
                before = list[index] + 1
            }
        }
        list[i] = before
    }
    return list.last()
}
