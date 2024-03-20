fun main() {
    val list = mutableListOf(64, 34, 25, 12, 22, 11, 90)
    sortInsert(list)
    println(list)
}

fun sortInsert(list: MutableList<Int>) {
  for (i in 1 until list.size) {
    for (j in 0 until i) {
      if (list[i] < list[j]) {
        val item = list[i]
        list.removeAt(i)
        list.add(j, item)
      }
    }
  }
}
