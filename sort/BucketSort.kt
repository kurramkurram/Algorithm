fun main() {
    val list = mutableListOf(1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 8, 10, 10, 12, 14, 14, 15)
    list.shuffle()
    println(list)
    val ret = sortBucket(list)
    println(ret)
}

fun sortBucket(list: MutableList<Int>): MutableList<Int> {
  val tmp = MutableList<MutableList<Int>>(list.max()) { mutableListOf<Int>() }
  list.forEachIndexed { index, v -> 
    tmp[v - 1].add(index)
  }
  val answer = mutableListOf<Int>()
  tmp.forEachIndexed { index, v ->
    repeat(v.size) {
      answer.add(index + 1)  
    } 
  }
  
  return answer
}

