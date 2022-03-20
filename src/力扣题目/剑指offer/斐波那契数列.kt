package 力扣题目.剑指offer

fun fib(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    val list = arrayListOf<Long>()
    list.add(0)
    list.add(1)
    for (i in 2..n) {
        list.add(
            (list[i - 1] + list[i - 2]) % 1000000007L
        )
    }
    return list[n].toInt()
}