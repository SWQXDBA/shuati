package 力扣题目.剑指offer


class 对称的二叉树 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return compare(root.left, root.right)
    }

    fun compare(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        if (left.`val` != right.`val`) return false
        return compare(left.left, right.right) && compare(left.right, right.left)

    }
}