package 力扣题目.剑指offer

fun exchange(nums: IntArray): IntArray {

    var ji = 0
    var ou = 0
    while (ji < nums.size && ou < nums.size) {


        while (nums[ou] % 2 != 0) {
            ou++
            if (ou == nums.size) {
                return nums
            }
        }
        ji = ou
        //找到一个在偶数后面的奇数
        while (nums[ji] % 2 == 0) {
            ji++
            if (ji == nums.size) {
                return nums
            }
        }
        //将其位置调换
        if (ji > ou) {
            val temp = nums[ji]
            nums[ji] = nums[ou]
            nums[ou] = temp
        }
    }
    return nums
}