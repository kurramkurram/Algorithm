fun main() {
    val list = mutableListOf(64, 34, 25, 12, 22, 11, 90)
    val ret = sortMerge(list)
    println(ret)
}

fun sortMerge(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1) return list

    val half = list.size / 2
    val left = sortMerge(list.slice(0..half - 1).toMutableList())
    val right = sortMerge(list.slice(half..list.size - 1).toMutableList())

    return merge(left, right)
}

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
    val merged = MutableList<Int>(left.size + right.size) { 0 }
    var leftIndex = 0
    var rightIndex = 0
    var mergedIndex = 0

    while (left.size > leftIndex && right.size > rightIndex) {
        if (left[leftIndex] < right[rightIndex]) {
            merged[mergedIndex] = left[leftIndex]
            leftIndex++
        } else {
            merged[mergedIndex] = right[rightIndex]
            rightIndex++
        }
        mergedIndex++
    }

    while (left.size > leftIndex) {
        merged[mergedIndex] = left[leftIndex]
        leftIndex++
        mergedIndex++
    }

    while (right.size > rightIndex) {
        merged[mergedIndex] = right[rightIndex]
        rightIndex++
        mergedIndex++
    }

    return merged
}
