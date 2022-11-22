package 力扣题目.剑指offer

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/*fun main() {
    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(9)
    treeNode.right = TreeNode(20)
    val right = treeNode.right
    right!!.left = TreeNode(15)
    right.right = TreeNode(7)
    println(levelOrder(treeNode).contentToString())
}*/

//层序遍历
fun levelOrder(root: TreeNode?): IntArray {

/*    val myTestQueue = MyTestQueue<String>()
    myTestQueue.fun1(null)
    myTestQueue.fun2(null)*/

    val list = mutableListOf<Int>()
    if (root == null) return intArrayOf()
    val queue = LinkedList<TreeNode>()
    queue.push(root)
    while (!queue.isEmpty()) {
        val node = queue.pollLast()
        if (node != null) {
            list.add(node.`val`)
            if (node.left != null) {
                queue.push(node.left)
                //     queue.add(node.left)//???这里为什么会报错呢

            }
            if (node.right != null) {
                queue.push(node.right)
            }
        }

    }
    return list.toIntArray()

}