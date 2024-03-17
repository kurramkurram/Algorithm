
import java.util.ArrayDeque

fun main() {
    val count = readLine()?.toInt() ?: return

    val list = List(count - 1) {
        readLine()?.split(" ")?.map(String::toInt) ?: return
    }

    val result = graphSearch(list, count)
    println("distance = $result")
}

/**
 * グラフ探索.
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

    /**
     * 最も遠いところを探す.
     *
     * @param start 開始位置
     * @return 最も遠い位置、開始位置から最も遠いところまでの距離
     */
    fun findFarthest(start: Int): Pair<Int, Int> {
        // queueに次に行ける位置を追加していき、行けるところがなくなったところが最も遠い箇所
        val queue = ArrayDeque<Triple<Int, Int, Int>>()

        queue.add(Triple(start, -1, 0))
        var farthest = 0
        var distance = 0

        while (queue.isNotEmpty()) {
            val (now, parent, dist) = queue.poll() ?: return farthest to distance
            farthest = now
            distance = dist

            // 今いるところから行けるところを取り出す
            for (v in adj[now]) {

                // 次行けるところと来たところが違えばqueueに入れていく
                if (v != parent) {
                    queue.add(Triple(v, now, dist + 1))
                }
            }
        }
        return farthest to distance
    }
    // 0を起点に開始する（どこでもよい）
    val farthest = findFarthest(0).first

    // 0から開始して一番遠いところから最も遠いところが最長区間
    return findFarthest(farthest).second
}
