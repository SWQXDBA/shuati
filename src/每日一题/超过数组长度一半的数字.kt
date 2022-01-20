package 每日一题

class 超过数组长度一半的数字 {

    fun MoreThanHalfNum_Solution(numbers: IntArray): Int {
        var current = numbers[0]
        var currentCount = 0
        numbers.forEach {
            if (it == current) {
                currentCount++
            } else {
                currentCount--
            }
            if (currentCount == 0) {
                current = it
                currentCount = 1
            }
        }
        return current
    }
}

fun main() {
    println(超过数组长度一半的数字().MoreThanHalfNum_Solution(listOf(1, 2, 3, 3, 3, 2, 3, 3).toIntArray()))
}