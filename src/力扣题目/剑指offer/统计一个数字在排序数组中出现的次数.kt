package 力扣题目.剑指offer

fun search(nums: IntArray, target: Int): Int {

    var cnt = 0
    for (number in nums) {
        if (number == target) cnt++
        if (number > target) return cnt
    }
    return cnt
}