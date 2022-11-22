package 每日一题

fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (i in 0 until 32) {
        var thisBit = 0
        nums.forEach {
            if (it.shr(i).and(1) == 1) {
                thisBit++
            }
        }
        result.or((thisBit % 3).shl(i)).also { result = it }
    }
    return result
}