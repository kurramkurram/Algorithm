fun main() {
    val list = mutableListOf(1005, 26, 10202, 5, 64, 2, 10, 1, 6)
    val ret = sortGnome(list)
    println(ret)
}

fun sortGnome(list: MutableList<Int>): MutableList<Int> {
    var i = 0
    while (i < list.size - 1) {
        if (list[i] > list[i + 1]) {
            val tmpI = list[i]
            list[i] = list[i + 1]
            list[i + 1] = tmpI
            i++
            
            for (j in i - 1 downTo 1) {
                if (list[j - 1] <= list[j]) break
                val tmpJ = list[j]
                list[j] = list[j - 1]
                list[j - 1] = tmpJ
                i = j
            }
          
        } else {
          i++
        }
    }
    return list
}
