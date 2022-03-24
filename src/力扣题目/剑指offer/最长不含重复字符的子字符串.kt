package 力扣题目.剑指offer

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}

//思路 如果前一个区间内出现了与当前字符相同的字符 则把新区间设置为 上一个相同字符到当前位置,   否则区间长度+1
fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    val map = mutableMapOf<Char, Int>()
    //以s[i]为结尾的最长子串长度 也是两个相同字符之间的距离间隔
    val dp = IntArray(s.length)

    var max = 1
    s.forEachIndexed { index: Int, c: Char ->

        if (index == 0) {
            map[c] = index
            dp[0] = 1
            return@forEachIndexed
        }

        //在前一个子串的范围内 有当前字符 则需要重置区间
        if (map.containsKey(c)) {
            val lastLength = index - map[c]!!//两个相同字符之间的距离
            //在范围内出现了相同字符 则需要重新设置区间为两个字符之间 新的区间在旧的区间(没有重复字符)之内 所以也可以保证其他字符不会重复

            // bacda... 此时原区间为bacd 新的区间为cda 其中cd在原区间内 保证了不重复
            if (lastLength <= dp[index - 1])
                dp[index] = lastLength
        } else {
            dp[index] = dp[index - 1] + 1
        }
        if (max < dp[index]) {
            max = dp[index]
        }
        map[c] = index

    }
    return max
}