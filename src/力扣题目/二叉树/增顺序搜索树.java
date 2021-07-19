package 力扣题目.二叉树;

import MyTools.TreeNode;

public class 增顺序搜索树 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = root;
        while (head != null && head.left != null) {
            head = head.left;
        }
        helper(root);
        return head;
    }

    //helper返回子树的最大值
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            TreeNode prev = helper(root.left);
            prev.right = root;
        }
        root.left = null;
        //找到右子树的最小值
        TreeNode right_small = root.right;
        while (right_small != null && right_small.left != null) {
            right_small = right_small.left;
        }
        //右子树的最大值就是整棵树的最大值
        TreeNode right_big = root.right == null ? root : helper(root.right);

        root.right = right_small;
        return right_big;
    }
}
