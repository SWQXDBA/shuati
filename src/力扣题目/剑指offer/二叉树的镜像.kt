package 力扣题目.剑指offer

class 二叉树的镜像 {
    fun mirrorTree(root: TreeNode?): TreeNode? {
        root ?: return null
        val temp = root.left
        root.left = root.right
        root.right = temp
        mirrorTree(root.left)
        mirrorTree(root.right)
        return root
    }
}