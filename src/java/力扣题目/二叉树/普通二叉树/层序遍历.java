package 力扣题目.二叉树.普通二叉树;

import MyTools.工具类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class 层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        //每个循环开始的时候 队列里面保存着这一层的所有元素
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            list.add(layer);
            int cnt = queue.size();
            //保证只取出这一层的所有元素
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return list;
    }
}
