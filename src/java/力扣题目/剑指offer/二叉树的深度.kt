package 力扣题目.剑指offer

import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {

    root ?: return 0
    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}