fun main() {
    val list = mutableListOf(1005, 26, 10202, 5, 64, 2, 10, 1, 6)
    val ret = sortShaker(list)
    println(ret)
}

fun sortShaker(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size / 2) {
        for (j in i until list.size - i - 1) {
            if (list[j] > list[j + 1]) {
                val tmp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = tmp
            }
        }
        for (j in list.size - i - 2 downTo i + 1) {
            if (list[j] < list[j - 1]) {
                val tmp = list[j]
                list[j] = list[j - 1]
                list[j - 1] = tmp
            }
        }
    }
    return list
}
