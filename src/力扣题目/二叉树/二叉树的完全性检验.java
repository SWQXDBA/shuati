package 力扣题目.二叉树;

import MyTools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOver = false;
        //思路：按照层序遍历把每个节点加进去 如果碰到一个null节点 说明应该结束（队列中剩下的应该都是叶子节点底下的null）
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isOver && node != null) {
                return false;
            }
            if (node == null) {
                isOver = true;
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }
}
