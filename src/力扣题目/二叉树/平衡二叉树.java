package 力扣题目.二叉树;

import MyTools.TreeNode;

public class 平衡二叉树 {
    static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
