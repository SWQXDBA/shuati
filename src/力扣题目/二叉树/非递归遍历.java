package 力扣题目.二叉树;

import MyTools.TreeNode;

import java.util.Stack;

public class 非递归遍历 {
    static void xianxu(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    static void zhongxu(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        do {
            //先一路把左边节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //此时root必然为null，表明左子树为空或者遍历完成，取出栈顶元素作为当前节点
            root = stack.pop();
            //访问当前节点
            System.out.print(root.val + " ");
            //开始访问右子树
            root = root.right;
            //倘若右子树也为空 说明这棵树遍历完成，会跳到 root = stack.pop();开始遍历上一个节点
        } while (root != null || !stack.isEmpty());
        System.out.println();
    }

    static void houxu(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastPeek = null;
        do {
            //先一路把左边节点入栈
            //倘若此时root已经为null 说明左子树已经遍历完成了!!!
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //此时root必然为null，表明左子树为空或者遍历完成,查看栈顶元素作为当前节点
            root = stack.peek();
            //如果是叶子节点 就直接访问
            if (root.left == null && root.right == null) {
                System.out.print(root.val + " ");
                lastPeek = root;
                stack.pop();
                root = null;//把root置为空是为了避免重复入栈
                continue;
            }
            //右子树还未访问过，则访问右子树
            if (lastPeek != root.right && root.right != null) {
                root = root.right;
                continue;
            }
            //右子树也访问过了，或者右子树为空，现在可以访问这个节点了
            System.out.print(root.val + " ");
            lastPeek = root;
            stack.pop();
            root = null;//把root置为空是为了避免重复入栈


        } while (root != null || !stack.isEmpty());
        System.out.println();
    }

    public static void main(String[] args) {
        //////            9
        //////         3     1
        //////        4 5   2
        //////       6        8

        //先序 9 3 4 6 5 1 2 8
        //中序 6 4 3 5 9 2 8 1
        //后序 6 4 5 3 8 2 1 9
        TreeNode tree = new TreeNode(9);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);
        tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(2);
        tree.right.left.right = new TreeNode(8);
        xianxu(tree);
        zhongxu(tree);
        houxu(tree);

    }
}
