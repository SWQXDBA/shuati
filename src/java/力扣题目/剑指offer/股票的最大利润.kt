package 力扣题目.剑指offer

fun main() {
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

fun maxProfit(prices: IntArray): Int {

    if (prices.isEmpty()) return 0
    val max = IntArray(prices.size)
    val min = IntArray(prices.size)


    var currentMax = prices[prices.size - 1]
    var currentMin = prices[0]
    for (i in prices.size - 1 downTo 0) {
        if (prices[i] > currentMax) {
            currentMax = prices[i]
        }
        max[i] = currentMax
    }
    for (i in prices.indices) {
        if (prices[i] < currentMin) {
            currentMin = prices[i]
        }
        min[i] = currentMin
    }

    var maxProfitNum = 0
    for (i in prices.indices) {
        val num = max[i] - min[i]
        if (num > maxProfitNum) {
            maxProfitNum = num
        }
    }
    return maxProfitNum
}