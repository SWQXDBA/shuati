package 力扣题目.剑指offer

var res = 0
var currentIndex = 0
fun kthLargest(root: TreeNode?, k: Int): Int {

    dfs(root, k)
    return res
}

fun dfs(root: TreeNode?, k: Int): Boolean {
    root ?: return false
    if (dfs(root.right, k)) return true
    currentIndex += 1
    if (currentIndex == k) {
        res = root.`val`
        return true
    }
    if (dfs(root.left, k)) return true
    return false
}