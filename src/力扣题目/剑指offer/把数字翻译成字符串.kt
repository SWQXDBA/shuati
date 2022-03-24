package 力扣题目.剑指offer

fun main() {
    println(translateNum(12258))
}

fun translateNum(num: Int): Int {
//    力扣好像没有那些扩展函数
    val s = "$num".toCharArray().map { it.toInt() - '0'.toInt() }


    val ints = IntArray(s.size)
    for (index in s.indices) {
        if (index == 0) {
            ints[index] = 1
            continue
        }
        ints[index] = ints[index - 1]
        if ((s[index - 1] in 1 until 2) ||
            (s[index - 1] == 2 && s[index] <= 5)
        ) {
            if (index == 1) {
                ints[index] += 1
            } else {
                ints[index] += ints[index - 2]
            }

        }
    }
    return ints[ints.size - 1]
}