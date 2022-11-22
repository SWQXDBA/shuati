package 力扣题目.剑指offer

fun main() {
    println(reverseLeftWords("12345", 2))
}

fun reverseLeftWords(s: String, n: Int): String {
    val move = n % s.length
    val charArray = CharArray(s.length)
    for (i in s.indices) {
        var index = i - move
        if (index < 0) {
            index += s.length
        }
        charArray[index] = s[i]
    }
    return String(charArray)
}