package 力扣题目.剑指offer

import java.util.*

class 从上到下打印二叉树III {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()
        val result = mutableListOf<List<Int>>()

        var flag = false;
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val queue2 = LinkedList<TreeNode>()
            while (!queue.isEmpty()) {
                queue2.add(queue.pop())
            }
            val list = queue2.toMutableList()
            if (flag) {
                list.reverse()

            }
            flag = !flag
            result.add(list.map { it.`val` })
            while (!queue2.isEmpty()) {
                val node = queue2.pop()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }
        return result
    }
}
