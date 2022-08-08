package 力扣题目.动态规划

import kotlin.math.min

class 跳跃游戏2 {
    class Solution {
        fun jump(nums: IntArray): Int {
            val dp = IntArray(nums.size)

            for (i in nums.indices) {
                val cur = dp[i]
                for (j in (i + 1)..(i + nums[i])) {
                    if (j >= nums.size) {
                        break
                    }
                    dp[j] =
                        if (dp[j] == 0) {
                            cur + 1
                        } else {
                            min(cur + 1, dp[j])
                        }

                }
            }
            return dp[dp.size - 1]
        }
    }
}