package 力扣题目.剑指offer;

import MyTools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 剑指07_重建二叉树 {
    Map<Integer, Integer> map = new HashMap();

    public static void main(String[] args) {
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buidHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode buidHelper(int[] preorder, int[] inorder, int px, int py, int ix, int iy) {
        if (px > py)
            return null;
        int root = map.get(preorder[px]);//根据值找出中序遍历中的下标

        int leftLength = root - ix;//算出左子树的长度
        int rightLength = iy - root;//算出右子树的长度

        TreeNode rootNode = new TreeNode(preorder[px]);//先创建根节点
        rootNode.left = buidHelper(preorder, inorder, px + 1, px + leftLength, ix, ix + leftLength);
        rootNode.right = buidHelper(preorder, inorder, px + leftLength + 1, py, ix + leftLength + 1, root + rightLength);
        return rootNode;
    }


}

//root left right
//left root right