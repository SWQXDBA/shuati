package 力扣题目.剑指offer

fun movingCount(m: Int, n: Int, k: Int): Int {
    val array = Array(m) { BooleanArray(n) }
    test(0, 0, m, n, k, array)
    var cnt = 0
    for (raw in array) {
        for (b in raw) {
            if (b) {
                cnt++
            }
        }
    }
    return cnt
}

fun canIndex1(x: Int, y: Int, xMax: Int, yMax: Int) = (x in 0 until xMax) && (y in 0 until yMax)
fun test(x: Int, y: Int, m: Int, n: Int, k: Int, array: Array<BooleanArray>) {
    if (!canIndex1(x, y, m, n) || !canIn(x, y, k) || array[x][y]) {
        return
    }
    array[x][y] = true
    test(x + 1, y, m, n, k, array)
    test(x - 1, y, m, n, k, array)
    test(x, y + 1, m, n, k, array)
    test(x, y - 1, m, n, k, array)
}

fun canIn(x: Int, y: Int, k: Int): Boolean {
    var num = 0
    var varX = x
    var varY = y
    while (varX > 0) {
        num += varX % 10
        varX /= 10
    }
    while (varY > 0) {
        num += varY % 10
        varY /= 10
    }
    return num <= k
}