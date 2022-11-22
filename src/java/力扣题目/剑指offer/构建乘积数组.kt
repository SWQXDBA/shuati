package 力扣题目.剑指offer

//摘抄的:
//整体思路，结果集中任何一个元素 = 其左边所有元素的乘积 * 其右边所有元素的乘积。一轮循环构建左边的乘积并保存在结果集中，二轮循环 构建右边乘积的过程，乘以左边的乘积，并将最终结果保存
//感谢大佬的解答，但是可能我比较笨，上三角下三角看了半天才理解在说什么。
// 我用我认为更简洁的语言描述一下这个算法。 算法一共遍历a数组两次，第一次正向第二次逆向。
// 第一次正向遍历a是为了创建辅助数组bb，其中bb[i]=a[1]*...*a[i]。
// 第二次逆向遍历a，当遍历至下标i时，输出的数组b[i]=bb[i-1]*a[i+1]*...a[-1]。
// bb[i-1]由第一次遍历得到，a[i+1]*...a[-1]由逆向遍历时变量tmp累乘得到。
fun main() {
    constructArr(intArrayOf(1, 2, 3, 4, 5))
}

fun constructArr(a: IntArray): IntArray {

    val left = IntArray(a.size)
    val right = IntArray(a.size)

    val result = IntArray(a.size)
    var x = 1
    var y = 1
    for (i in a.indices) {
        left[i] = x
        x *= a[i]

        right[a.size - 1 - i] = y
        y *= a[a.size - 1 - i]

    }
    for (i in result.indices) {
        result[i] = left[i] * right[i]
    }

    return result
}