
// 全探索
fun main() {
    val (A, B, C, D) = readLine()?.split(" ")?.map(String::toInt) ?: return
    val inputList = listOf(A, B, C, D)
    val allList = getAllList(inputList)
    allList.forEach { it -> 
        println("$it")
    }
}

/**
 * 組み合わせのリストを作成する.
 * 重複があれば削除する.
 *
 * @param input 組み合わせを調べる元のリスト
 * @return 組み合わせリスト
 */
fun getAllList(input: List<Int>): MutableList<String> {
    val inputSize = input.size
    val allList = mutableListOf<String>()
    val element = MutableList(inputSize) { 0 }
    val used = MutableList(inputSize) { false }

    fun permutation(n: Int) {
        if (n == inputSize) {
            val item = element.joinToString("")
            if (!allList.contains(item)) {
                allList.add(item)
            }

        } else {
            for (i in 0 until inputSize) {
                if (used[i]) continue
                element[n] = input[i]
                used[i] = true
                permutation(n + 1)
                used[i] = false
            }
        }
    }
    permutation(0)
    return allList
}