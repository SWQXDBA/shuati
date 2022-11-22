package 力扣题目.剑指offer;

public class 剑指28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root.left, root.right);

    }

    boolean dfs(TreeNode left, TreeNode right) {
        if (left == right && left == null) {
            return true;
        }
        if (left == null || right == null)
            return false;
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
