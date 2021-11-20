package MyTools.我的数据结构.数据结构实验;

import MyTools.我的数据结构.Tree.BinaryTree.BinarySerchTree.MyBinarySearchTree;
import MyTools.我的数据结构.Tree.BinaryTree.BinarySerchTree.TreeNodeBase;
import MyTools.我的数据结构.Tree.BinaryTree.TreePrinter;

public class 实验三二叉树 {
    public static void main(String[] args) {
        MyBinarySearchTree<String> tree = new MyBinarySearchTree<>();
        tree.root = new TreeNodeBase<>("A");
        tree.root.left = new TreeNodeBase<>("B");
        tree.root.left.left = new TreeNodeBase<>("C");
        tree.root.left.right = new TreeNodeBase<>("D");
        TreeNodeBase<String> D = tree.root.left.right;
        D.left = new TreeNodeBase<>("E");
        D.right = new TreeNodeBase<>("F");
        TreeNodeBase<String> E = D.left;
        E.right = new TreeNodeBase<>("G");
        TreePrinter.showTree(" ", tree.root);

        System.out.println("前序遍历:");
        tree.prev(tree.root);
        System.out.println();
        System.out.println("中序遍历:");
        tree.mid(tree.root);
        System.out.println();
        System.out.println("后序遍历:");
        tree.after(tree.root);
        System.out.println();
        System.out.println("二叉树的高度:" + tree.deep(tree.root));
        System.out.println("元素个数:" + tree.nodeCount(tree.root));
        System.out.println("分别搜索C、K两个元素，并给出搜索结果");
        System.out.println(tree.search(tree.root, "C"));
        System.out.println(tree.search(tree.root, "K"));
        System.out.println("插入一个新的元素I");
        tree.insert("I");
        tree.showTree(" ");
    }
}
