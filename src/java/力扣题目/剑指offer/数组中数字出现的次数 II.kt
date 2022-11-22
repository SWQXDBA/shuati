package 力扣题目.剑指offer

fun main() {
    println(singleNumber(intArrayOf(1, 5, 1, 1)))
}

//把数组中所有数字的二进制表示的每一位加起来，如果某一位的和可以被 3 整除，那么那个只出现一次的数字二进制表示中对应的那一位是 0，否则是 1。
fun singleNumber(nums: IntArray): Int {

    val bits = IntArray(32)
    for (i in nums) {
        for (j in 0 until 32) {
            bits[j] += i.shr(j).and(1)
        }
    }
    var res = 0
    for (i in bits.indices) {
        res = res.shl(1).or(bits[31 - i] % 3)
    }
    return res
}