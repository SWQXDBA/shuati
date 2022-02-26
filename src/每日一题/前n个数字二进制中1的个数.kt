package 每日一题

fun main() {


}

fun countBits(n: Int): IntArray {

    val result = IntArray(n + 1)
    var heightBit = 0
    if (n > 0) {
        for (i in 1..n) {
            if (i.and(i - 1) == 0) {
                heightBit = i
            }
            result[i] = result[i - heightBit] + 1
        }
    }

    return result
}