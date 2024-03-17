fun main() {
    val list = mutableListOf(64, 34, 25, 12, 22, 11, 90)
    val ret = sortQuick(list)
    println(ret)
}


fun sortQuick(list: MutableList<Int>): MutableList<Int> {
    if (list.isEmpty()) return list
    val pivot = list[0]

    var left = mutableListOf<Int>()
    var right = mutableListOf<Int>()

    for (i in 1 until list.size) {
        val v = list[i]
        if (v < pivot) {
            left.add(v)
        } else {
            right.add(v)
        }
    }
    left = sortQuick(left)
    right = sortQuick(right)
    left.add(pivot)
    left.addAll(right)

    return left
}