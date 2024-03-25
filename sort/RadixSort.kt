import java.lang.Math.log10

fun main() {
    val list = mutableListOf(1005, 10, 20202, 5, 64, 2, 26, 1)
    val ret = sortRadix(list)
    println(ret)
}
fun sortRadix(list: MutableList<Int>): MutableList<Int> {
    val maxDigit = log10(list.max().toDouble()).toInt()
    var sorted: MutableList<Int> = list
    repeat(maxDigit + 1) { cnt ->
        sorted = sort(sorted, cnt)
    }

    return sorted
}

fun sort(list: MutableList<Int>, digit: Int): MutableList<Int> {
    // 各位を0-9のどれかで格納していくためサイズ10のリスト
    val tmp = MutableList<MutableList<Int>>(10) { mutableListOf<Int>() }
    val ret = mutableListOf<Int>()

    list.forEach { it ->
        val str = it.toString()
        if (str.length - 1 < digit) {
            tmp[0].add(it)
        } else {
            val index = str.length - digit
            val v = str.substring(index - 1, index).toInt()
            tmp[v].add(it)
        }
    }

    tmp.forEach { it1 ->
        it1.forEach { it2 ->
            ret.add(it2)
        }
    }
    return ret
}