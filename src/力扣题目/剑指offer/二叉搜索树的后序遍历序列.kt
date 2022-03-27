package 力扣题目.剑指offer

//最右边的元素为根节点 从左到右第一个大于根节点的元素应该为右子树的起始点
//[左子树][右子树][根节点]
fun verifyPostorder(postorder: IntArray): Boolean {
    return match(postorder, 0, postorder.size - 1)
}

fun match(postorder: IntArray, left: Int, right: Int): Boolean {
    if (left >= right) return true
    val root = postorder[right]
    for (i in left..right) {
        if (postorder[i] > root) {
            if (!isSearchTree(postorder, left, i - 1, i, right - 1, root)) return false
            return match(postorder, left, i - 1) && match(postorder, i, right - 1)
        }
    }
    //全部在左子树
    return match(postorder, left, right - 1)
}

fun isSearchTree(
    postorder: IntArray,
    leftTreeLeft: Int,
    leftTreeRight: Int,
    rightTreeLeft: Int,
    rightTreeRight: Int,
    root: Int
): Boolean {
    for (i in leftTreeLeft..leftTreeRight) {
        if (postorder[i] > root) return false
    }
    for (i in rightTreeLeft..rightTreeRight) {
        if (postorder[i] < root) return false
    }
    return true
}

fun main() {
    println(verifyPostorder(intArrayOf(5, 2, -17, -11, 25, 76, 62, 98, 92, 61)))
}