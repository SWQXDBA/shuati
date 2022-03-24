package 力扣题目.剑指offer

fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    var right = nums.size - 1
    var left = 0
    while (left < right) {
        val leftVal = nums[left]
        val rightVal = nums[right]
        if (leftVal + rightVal == target) {
            result[0] = leftVal
            result[1] = rightVal
            return result
        }
        if (leftVal + rightVal > target) {
            right--;
        } else {
            left++
        }
    }

    return result
}