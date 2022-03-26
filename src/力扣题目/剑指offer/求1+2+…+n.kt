package 力扣题目.剑指offer

fun sumNums(i: Int): Int {
    var n = i
    val b = n > 0 && n.apply { n += sumNums(n - 1) } > 0
    return n
}
