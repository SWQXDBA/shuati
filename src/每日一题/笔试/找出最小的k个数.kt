package 每日一题.笔试

import java.util.*

fun GetLeastNumbers_Solution(input: IntArray, k: Int): IntArray {
    val heap = PriorityQueue<Int> { o1, o2 ->
        o2 - o1
    }
    input.forEach {
        heap.add(it)
        if (heap.size > k) {
            heap.poll()
        }
    }
    return heap.toIntArray().reversed().toIntArray()
}
