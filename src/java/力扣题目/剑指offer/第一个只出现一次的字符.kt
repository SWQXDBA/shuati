package 力扣题目.剑指offer

fun firstUniqChar(s: String): Char {
    val map = mutableMapOf<Char, Int>()

    s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    map.forEach { if (it.value == 1) return it.key }
    return ' '
}