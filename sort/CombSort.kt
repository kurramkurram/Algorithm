fun main() {
    val list = mutableListOf(1005, 26, 10202, 5, 64, 2, 10, 1, 6)
    val ret = sortComb(list)
    println(ret)
}

fun sortComb(list: MutableList<Int>): MutableList<Int> {
    // https://ja.wikipedia.org/wiki/%E3%82%B3%E3%83%A0%E3%82%BD%E3%83%BC%E3%83%88
    var interval = kotlin.math.floor(list.size / 1.3).toInt()
    while (interval > 0) {
        for (i in 0 until list.size) {
            for (j in i until list.size - i - 1) {
                if (j + interval >= list.size) break
                if (list[j] > list[j + interval]) {
                    val tmp = list[j]
                    list[j] = list[j + interval]
                    list[j + interval] = tmp
                }
            }
        }
        interval = kotlin.math.floor(interval / 1.3).toInt()
    }
    return list
}
