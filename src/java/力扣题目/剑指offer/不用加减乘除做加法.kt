package 力扣题目.剑指offer

fun add(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val temp = x xor y
        y = x.and(y).shl(1)
        x = temp

    }
    return x

}

fun main() {
    println(add(3, 5))
}