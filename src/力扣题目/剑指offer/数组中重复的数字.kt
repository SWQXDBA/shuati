package 力扣题目.剑指offer

class 数组中重复的数字 {
}

fun main() {
    println(findRepeatNumber(intArrayOf(1, 3, 2, 3)))
}

fun findRepeatNumber(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        //当前元素
        val current = nums[i]
        // 索引和元素相同
        if (current == i) {
            i++
            continue
        }
        //当前元素应该处于的,目标位置的元素
        val target = nums[current]
        //目标位置的元素与当前元素相同 则返回
        if (target == current) {
            return current
        }

        //否则进行交换 把当前元素放在相应的索引位置上
        nums[current] = current
        nums[i] = target
    }

    return -1
}