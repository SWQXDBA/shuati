package 力扣题目.动态规划

class 最长回文子串 {
    /**
     *   暴力解法
     */

    class Solution1 {
        fun longestPalindrome(s: String): String {
            var max = 0
            var maxString = ""
            for (i in s.indices) {
                for (j in i until s.length) {
                    if (match(s, i, j)) {
                        val len = j - i
                        if (len >= max) {
                            max = len
                            maxString = s.substring(i..j)
                        }
                    }
                }
            }
            return maxString
        }

        fun match(s: String, start: Int, end: Int): Boolean {
            var left = start
            var right = end
            while (left <= right) {
                if (left == right) {
                    return true
                }
                if (left < right) {
                    if (s[left] == s[right]) {
                        left++
                        right--
                    } else {
                        return false
                    }
                }
            }
            return true
        }
    }

    /**
     * 动态规划
     */
    class Solution {
        fun longestPalindrome(s: String): String {

            if (s.length == 1) {
                return s
            }
            if (s.length == 2) {
                if (s[0] == s[1]) {
                    return s
                } else {
                    return s[0].toString()
                }
            }
            //数组开大一点
            val dp = Array(s.length + 5) { i ->
                BooleanArray(s.length + 5)
            }
            for (i in dp.indices) {
                dp[i][i] = true
            }
            var max = 0
            var maxString = ""
            //遍历不同的长度
            for (i in 2..s.length) {
                for (j in 0..s.length - i) {
                    val left = j
                    val right = j + i - 1

                    if ((right - left == 1 || dp[left + 1][right - 1]) && s[left] == s[right]) {
                        dp[left][right] = true
                        if (max <= i) {
                            maxString = s.substring(left..right)
                            max = i
                        }
                    }
                }
            }
            if (max == 0) {
                return if (s.length == 0) {
                    ""
                } else {
                    s[0].toString()
                }
            }
            return maxString

        }

    }

}

fun main() {
    println(最长回文子串.Solution().longestPalindrome("aaaa"))
}