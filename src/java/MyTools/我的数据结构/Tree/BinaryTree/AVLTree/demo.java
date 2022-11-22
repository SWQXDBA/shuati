package MyTools.我的数据结构.Tree.BinaryTree.AVLTree;

import MyTools.工具类.RandomTool;
import MyTools.我的数据结构.Tree.BinaryTree.BinarySerchTree.MyBinarySearchTree;
import MyTools.我的数据结构.Tree.BinaryTree.TreePrinter;

public class demo {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Integer[] random = RandomTool.generateRandomArray(i -> Math.abs(i % 100), 10, Integer[].class);
        for (var i : random) {

            tree.insert(i);

        }

        TreePrinter.showTree("      ", tree.root);
        System.out.println("_______________________________________________");
        MyBinarySearchTree<Integer> tree1 = new MyBinarySearchTree<>();
        tree1.insert(5);
        tree1.insert(3);
        tree1.insert(4);

        TreePrinter.showTree("   ", tree1.root);
        System.out.println("________________________________________________");
//        tree.clean();
//
//        tree.insert(1);
//        tree.insert(12);
//        tree.insert(20);
//        tree.insert(15);
//        tree.insert(27);
//
//        tree.insert(29);
//        tree.insert(35);
//        tree.insert(47);
//        TreePrinter.showTree("   ",tree.root);
    }
}
