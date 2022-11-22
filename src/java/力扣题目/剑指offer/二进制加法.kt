package 力扣题目.剑指offer


fun main() {

    fun addBinary(a: String, b: String): String {
        var p1 = a.length - 1
        var p2 = b.length - 1
        var temp = 0
        val list: MutableList<Int> = ArrayList()
        while (p1 >= 0 || p2 >= 0) {
            val num1 = if (p1 >= 0) a[p1].toInt() - '0'.toInt() else 0
            val num2 = if (p2 >= 0) b[p2].toInt() - '0'.toInt() else 0
            var num3 = num1 + num2 + temp
            if (num3 > 1) {
                temp = 1
                num3 -= 2
            } else {
                temp = 0
            }
            p1--
            p2--

            list.add(num3)
        }
        if (temp != 0) {

            list.add(temp)
        }


        list.reverse()
        val sb = StringBuilder()
        list.forEach { sb.append(it) }
        return sb.toString()
    }
    println(addBinary("11", "10"))
}