package 力扣题目.剑指offer

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
fun singleNumbers(nums: IntArray): IntArray {

    var target = 0
    for (i in nums) {
        target = target xor i
    }
    //此时target为那两个数字的异或结果 两个数字在 target为1的位的地方必然不同
    var index = 0
    while (target and 1 == 0) {
        target = target.shr(1)
        index++
    }
    val result = IntArray(2)
    for (i in nums) {
        if (i.shr(index).and(1) == 1) {

            result[0] = result[0].xor(i)
            println("1: $i, ${result[0]} ")
        } else {
            result[1] = result[1].xor(i)
            println("2: $i, ${result[1]} ")
        }
    }
    return result
}

fun main() {
    println(singleNumbers(intArrayOf(4, 1, 4, 6))[0])

}