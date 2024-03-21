fun main() {
    val list = mutableListOf(64, 34, 25, 12, 22, 11, 90)
    sortSelect(list)
    println(list)
}

fun sortSelect(list: MutableList<Int>) {
    val size = list.size
    for (i in 0 until size - 1) {
      var index = i
      for (j in i + 1 until size) {
        if (list[index] > list[j]) {
          index = j
        }
      }
      val tmp = list[index]
      list[index] = list[i]
      list[i] = tmp
    }
}
