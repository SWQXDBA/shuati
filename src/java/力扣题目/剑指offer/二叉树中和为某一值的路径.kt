package 力扣题目.剑指offer

import java.util.*
import kotlin.collections.ArrayList

class Solution1 {
    val result: MutableList<List<Int>> = ArrayList()
    fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
        if (root == null) return result
        test(root, target, 0, Stack<Int>())
        return result
    }

    fun test(current: TreeNode, target: Int, currentNum: Int, stack: Stack<Int>) {
        if (current.left == null && current.right == null) {
            if (currentNum + current.`val` == target) {
                stack.push(current.`val`)
                result.add(stack.toList())
                stack.pop()
            }
        } else {
            stack.push(current.`val`)
            current.left?.let {
                test(current.left!!, target, currentNum + current.`val`, stack)
            }
            current.right?.let {
                test(current.right!!, target, currentNum + current.`val`, stack)
            }
            stack.pop()

        }

    }
}