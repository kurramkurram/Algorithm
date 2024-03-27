fun main() {
    val list = mutableListOf(64, 34, 25, 12, 22, 90, 11)
    sortShell(list)
    println(list)
}

fun sortShell(list: MutableList<Int>) {
  // 間隔をリストサイズの半分で開始する
  var interval = list.size / 2
  while (interval > 0) {
    for (i in interval until list.size) {
      for (j in 0 until i step interval) {
        if (list[i] < list[j]) {
          val item = list[i]
          list.removeAt(i)
          list.add(j, item)
        }
      }
    }
    interval --
  }
}
