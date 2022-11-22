package 力扣题目.背包

import java.util.Scanner
import kotlin.math.max

//https://zhuanlan.zhihu.com/p/430195885
//	p[i][j]=MAX{p[i-1][j-volume[i]]+value[i],p[i-1][j]};
//	解释一下：p[i][j]代表前i件物品组合在容量为j的背包的最优解。将前i件物品放入容量为v的背包中这个子问题，
//	若只考虑第i件物品的策略（放或不放），那么就可以转化为一个只牵扯前i-1件物品的问题。
//	如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中，价值为p[i-1][v]；
//	如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的容量为v-volume[i]的背包中”，
//	此时能获得的最大价值就是p[i-1][j-volume[i]]再加上通过放入第i件物品获得的价值value[i]。
//————————————————
//版权声明：本文为CSDN博主「pirates」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/liangbopirates/article/details/9750463
fun main() {
    var n = 0
    var volume = 0
    val scanner = Scanner(System.`in`)
    n = scanner.nextInt()
    volume = scanner.nextInt()
    scanner.nextLine()
    val softSize = IntArray(n+1)
    val softImportance = LongArray(n+1)
    for (i in 1 .. n) {
        softSize[i] = scanner.nextInt()
        softImportance[i] = scanner.nextLong()
    }
//    对于第一行和第一列是要初始化为0，因为没有物品放入的最优解就是0，以及体积为0的背包不能放入物品最优解也是0
    val dp = Array(n+1){ LongArray(volume+1) }

    for (i in 1 .. n){
        for (j in 1 .. volume){
            if(softSize[i]<=j){
                dp[i][j]= max(dp[i-1][j-softSize[i]]+softImportance[i],dp[i-1][j])
            }else{
                dp[i][j] = dp[i-1][j]
            }

        }
    }
    println(dp[n][volume])
}