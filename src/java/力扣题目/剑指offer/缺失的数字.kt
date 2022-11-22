package 力扣题目.剑指offer

fun missingNumber(nums: IntArray): Int {
    var mid = 0
    var right = nums.size - 1
    var left = 0
    while (left <= right) {
        mid = (left + right) / 2
        if (nums[mid] != mid) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return left
}