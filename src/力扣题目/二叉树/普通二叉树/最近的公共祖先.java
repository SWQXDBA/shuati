package 力扣题目.二叉树.普通二叉树;

import MyTools.TreeNode;

public class 最近的公共祖先 {
    //第一种 后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //先看左子树有没有公共祖先
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        if (node != null) {
            return node;
        } else {
            node = lowestCommonAncestor(root.right, p, q);
        }
        ////再看右子树有没有公共祖先
        if (node != null) {
            return node;
        } else {
            //看看自己是不是公共祖先
            node = hasSubNode(root, p) && hasSubNode(root, q) ? root : null;
        }
        return node;

    }

    boolean hasSubNode(TreeNode root, TreeNode target) {
        return root == null ? target == null : root == target || hasSubNode(root.left, target) || hasSubNode(root.right, target);
    }


}
