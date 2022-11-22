package 力扣题目.剑指offer

fun main() {
    println(myPow(2.0, 9))
}

fun myPow(x: Double, n: Int): Double {

    var vx = x
    var vn = n.toLong()
    if (n < 0) {
        vx = 1 / vx
        vn = -vn
    }
    var ret = 1.0

    while (vn > 0) {
        if (vn and 1L == 1L) {
            ret *= vx
            vx--
        }
        //要乘的位数/2
        vn = vn shr 1
        vx *= vx
    }
    return ret
}