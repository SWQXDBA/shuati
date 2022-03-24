package 力扣题目.剑指offer


fun reverseWords(s: String) = s.split(" ").reversed()
    .filter { !it.contains(" ") && it != "" && it.isNotEmpty() }
    .ifEmpty { null }?.reduce { acc, str -> "$acc $str" }
    ?.trim() ?: ""

fun main() {
    println(reverseWords2("1 2  3"))
}

fun reverseWords2(s: String) = s.split(Regex(" +")).reversed()
    .reduce { acc, str -> "$acc $str" }
    .trim()