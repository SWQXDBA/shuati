package 力扣题目.剑指offer

class 树的子结构 {
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        A ?: return false
        B ?: return false
        return isSubStructure(A.left, B) || isSubStructure(A.right, B) || match(A, B);
    }

    fun match(A: TreeNode?, B: TreeNode?): Boolean {
        B ?: return true
        A ?: return false
        return A.`val` == B.`val` && match(A.left, B.left) && match(A.right, B.right)
    }
}