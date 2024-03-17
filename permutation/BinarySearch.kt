
fun main() {
    val count = readLine()?.toInt() ?: return
    val line = readLine()?.split(" ")?.map(String::toInt) ?: return
    if (count != line.size) return
    val binary = readLine()?.toInt() ?: return
    val result = binarySearch(line, binary)
    println("result = $result")
}

/**
 * 二分探索.
 * 
 * @param item 探索する配列
 * @param binary 境界値
 * @return 条件を満たすindex
 */
fun binarySearch(item: List<Int>, binary: Int): Int {
    var ng = -1
    var ok = item.size
    while(ok - ng > 1) {
        val middle = (ok + ng) / 2
        if (isOk(item[middle], binary)) {
            ok = middle
        } else {
            ng = middle
        }
    }
    return ok
}

/**
 * 判定処理.
 * 
 * @param element 判定対象
 * @param binary 境界値
 * @return true 条件を満たす
 */
fun isOk(element: Int, binary: Int) = element >= binary



fun linearSearch(item: List<Int>, binary: Int) Int {
    item.forEachIndexed { index, it -> 
        if (it >= binary) return index
    }
}