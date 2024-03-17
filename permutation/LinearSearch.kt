fun main() {
  val count = readLine()?.toInt() ?: return
  val line = readLine()?.split(" ")?.map(String::toInt) ?: return
  if (count != line.size) return
  val binary = readLine()?.toInt() ?: return
  val result = linearSearch(line, binary)
  println("result = $result")
}

/**
 * 線形探索.
 *
 * @param item 探索する配列
 * @param binary 境界値
 * @return 条件を満たすindex
 */
fun linearSearch(item: List<Int>, binary: Int): Int {
    item.forEachIndexed { index, it ->
        if (it >= binary) return index
    }
    return -1
}