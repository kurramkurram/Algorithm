import java.util.*

fun main() {
    val count = readLine()?.toInt() ?: return

    val list = List(count - 1) {
        readLine()?.split(" ")?.map(String::toInt) ?: return
    }

    val result = graphSearch(list, count)
    println("distance = $result")
}

/**
 * グラフ探索(深さ優先探索).
 * 
 * @param item グラフ探索を行う配列.
 * @return 最も遠いところまでの距離のある区間の距離
 */
fun graphSearch(item: List<List<Int>>, count: Int): Int {
    val adj = MutableList<MutableList<Int>>(item.size + 1) { mutableListOf() }
    for (i in item.indices) {
        // 0オリジンで始めたいので1引く
        val start = item[i][0] - 1
        val end = item[i][1] - 1
        // 近接リストを作成していく
        adj[start].add(end)
        adj[end].add(start)
    }

    val queue = ArrayDeque<Int>()
    var farthest = -1
    var distance = 0

    fun dfs(
        index: Int
    ): Pair<Int, Int> {
        adj[index].forEach { it ->
            if (!queue.contains(it)) {
                queue.add(it)
                dfs(it)
            } else {
                if (queue.size - 1 > distance) {
                    distance = queue.size - 1
                    farthest = queue.last
                }
            }
        }

        queue.remove(index)
        return farthest to distance
    }
    
    queue.add(0)
    val target = dfs(0).first
    
    queue.add(target)
    return dfs(target).second
}
