package 力扣题目.二叉树.普通二叉树;


import MyTools.工具类.TreeNode;

public class 重建二叉树中后 {
    //    左子树 根节点  右子树
//    左子树 右子树 根节点
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int in_left, int in_right, int post_left, int post_right) {
        if (in_left > in_right || post_left > post_right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_right]);
        int index = getRootIndex(inorder, in_left, in_right, root.val);
        int leftTreeLength = index - 1 - in_left;//左子树的长度
        root.left = build(inorder, postorder, in_left, index - 1, post_left, post_left + leftTreeLength);
        root.right = build(inorder, postorder, index + 1, in_right, post_left + leftTreeLength + 1, post_right - 1);
        return root;
    }

    public int getRootIndex(int[] inorder, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
