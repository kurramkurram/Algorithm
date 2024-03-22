fun main() {
    val list = mutableListOf(1005, 26, 10202, 5, 64, 2, 10, 1, 6)
    val ret = sortHeap(list)
    println(ret)
}

fun sortHeap(list: MutableList<Int>): MutableList<Int> {
    val answer = mutableListOf<Int>()
    while (list.size > 0) {
        for (i in list.size - 1 downTo 1) {
            val parentIndex = if (i % 2 == 0) {
                i / 2 - 1
            } else {
                i / 2
            }

            if (list[parentIndex] > list[i]) {
                val tmp = list[i]
                list[i] = list[parentIndex]
                list[parentIndex] = tmp
            }
        }
        answer.add(list[0])
        list.removeAt(0)
    }
    return answer
}
