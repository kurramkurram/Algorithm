fun main() {
    val n = readLine()!!.toInt()

    if (n % 2 == 1) return println("")

    val ans = mutableListOf<String>()
    repeat(1.shl(n)) { bits ->
        val brackets = mutableListOf<String>()
        repeat(n) { i ->
            brackets.add(bits.shr(i).and(1).toString())
        }
        println(brackets.joinToString(""))
        if (!isBrackets(brackets)) return@repeat
        ans.add(brackets.joinToString(""))
    }
    ans.sorted().forEach { it ->
        println(it)
    }
}

fun isBrackets(brackets: MutableList<String>): Boolean {
    var cnt = 0
    brackets.forEach {
        cnt += if (it == "1") 1 else -1
        if (cnt < 0) return false
    }
    return cnt == 0
}
