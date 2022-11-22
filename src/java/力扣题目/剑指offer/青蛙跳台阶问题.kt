package 力扣题目.剑指offer

fun main() {
    println(numWays(7))
}

fun numWays(n: Int): Int {

    val array = LongArray(n + 3)
    array[0] = 1
    array[1] = 1
    array[2] = 2
    for (i in 3..n) {
        array[i] = (array[i - 2] + array[i - 1]) % 1000000007
    }
    return array[n].toInt()
}