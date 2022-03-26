package 力扣题目.剑指offer

import kotlin.math.max
import kotlin.math.min

fun isStraight(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    var min = 666
    var max = -1
    for (i in nums) {
        if (i == 0) continue
        if (set.contains(i)) {
            return false
        }
        min = min(min, i)
        max = max(max, i)
        set.add(i)
    }
    return max - min < 5
}