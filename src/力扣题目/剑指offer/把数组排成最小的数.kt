package 力扣题目.剑指offer

import java.util.*

fun main() {
    println(minNumber(intArrayOf(3, 30, 34, 5, 9)))
}


fun minNumber(nums: IntArray): String {
    val array = nums.toTypedArray()
    Arrays.sort(array) { i1, i2 ->
        val string1 = i1.toString() + i2.toString()
        val string2 = i2.toString() + i1.toString()

        return@sort string1.compareTo(string2)
    }

    return array.map { it.toString() }.reduce { str, num ->
        return@reduce str + num
    }

}


