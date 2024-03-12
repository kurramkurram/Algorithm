fun main() {
    val list = mutableListOf(64, 34, 25)
    sortBubble(list)
    println(list)
}

fun sortBubble(list: MutableList<Int>) {
    val size = list.size
    for (i in 0 until size) {
        for (j in 0 until size - i - 1) {
            if (list[j] > list[j + 1]) {
                val tmp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = tmp
            }
        }
    }
}