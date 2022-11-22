package 力扣题目.剑指offer

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

fun maxSubArray(nums: IntArray): Int {

    if (nums.isEmpty()) return 0


    var maxVal = nums[0]
    var currentMax = nums[0]
    for (index in nums.indices) {
        if (index == 0) {
            continue
        }
        val i = nums[index]
        if (currentMax < 0) {
            currentMax = 0
        }
        currentMax += i
        if (currentMax > maxVal) {
            maxVal = currentMax
        }
    }
    return maxVal
}