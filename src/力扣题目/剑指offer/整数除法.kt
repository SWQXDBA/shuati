package 力扣题目.剑指offer

fun main() {

    println(divide2(-2147483648, -1))
}

//采用减法代替除法
fun divide1(a: Int, b: Int): Int {

    var flag1 = a >= 0
    var flag2 = b >= 0
    var result = 0L
    var first = if (a > 0) a.toLong() else -a.toLong()
    var second = if (b > 0) b.toLong() else -b.toLong()
    while (first >= second) {
        result++
        first -= second
    }

    //两数符号相等结果就是正的
    val resultFlag = flag1 == flag2
    if (resultFlag) {
        result = if (result > Int.MAX_VALUE) Int.MAX_VALUE.toLong() else result
    } else {
        result *= -1
        result = if (result < Int.MIN_VALUE) Int.MIN_VALUE.toLong() else result
    }
    return result.toInt()
}

//采用位运算 二分搜索
fun divide2(a: Int, b: Int): Int {

    val flag1 = a >= 0
    val flag2 = b >= 0
    var result = 0L
    val first = if (a > 0) a.toLong() else -a.toLong()
    val second = if (b > 0) b.toLong() else -b.toLong()

    var tFirst = first
    var tSecond = second
    //思路：每次把除数扩大两倍 进行尝试 当除数大于被除数后 把被除数减去上一轮的除数 然后和原始除数继续算
    while (tFirst >= tSecond) {
        //位移次数
        var moveCount = 0L
        while (tFirst >= tSecond) {
            //<<一次 相当于*2
            tSecond = tSecond shl 1

            moveCount = if (moveCount == 0L) 1 else moveCount shl 1
        }
        result += moveCount
        //出循环时 除数大于被除数了 要退回去一次
        tFirst -= tSecond shr 1
        tSecond = second

    }

    //两数符号相等结果就是正的
    val resultFlag = flag1 == flag2
    if (resultFlag) {
        result = if (result > Int.MAX_VALUE) Int.MAX_VALUE.toLong() else result
    } else {
        result *= -1
        result = if (result < Int.MIN_VALUE) Int.MIN_VALUE.toLong() else result
    }
    return result.toInt()
}