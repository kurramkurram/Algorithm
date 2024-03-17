fun main() {
    val list = mutableListOf(1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 8, 10, 10, 12, 14, 14, 15)
    list.shuffle()
    val ret = sortCount(list)
    println(ret)
}

fun sortCount(list: MutableList<Int>): MutableList<Int> {
    val tmp = MutableList(list.max()) { 0 }
    list.forEach { it ->
        tmp[it - 1]++
    }

    val answer = mutableListOf<Int>()
    tmp.forEachIndexed { index, v ->
        repeat(v) {
            answer.add(index + 1)
        }
    }
    return answer
}
