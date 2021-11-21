package MyTools.我的数据结构.Tree.Huffman;

import MyTools.我的数据结构.Tree.BinaryTree.BinarySerchTree.MyBinarySearchTree;
import MyTools.我的数据结构.Tree.BinaryTree.BinarySerchTree.TreeNodeBase;
import MyTools.我的数据结构.Tree.BinaryTree.TreePrinter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;

public class HuffmanTree<T extends Comparable<T>> {
    PriorityQueue<TreeNodeBase<Integer>> stack = new PriorityQueue<>();
    MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
    Function<? super T, ? extends Integer> mapper;

    public HuffmanTree(Collection<T> collection, Function<? super T, ? extends Integer> mapper) {
        this.mapper = mapper;
        for (T t : collection) {
            stack.offer(new TreeNodeBase<>(mapper.apply(t)));
        }

        build();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(25);
        list.add(3);
        list.add(6);
        list.add(10);
        list.add(11);
        list.add(36);
        list.add(4);

        HuffmanTree<Integer> tree = new HuffmanTree<>(list, integer -> integer);
        System.out.println(tree);
    }

    private void build() {
        while (!stack.isEmpty()) {
            TreeNodeBase<Integer> left = stack.poll();
            if (stack.isEmpty()) {
                tree.root = left;
                return;
            }
            TreeNodeBase<Integer> right = stack.poll();
            TreeNodeBase<Integer> sum = new TreeNodeBase<>(left.getVal() + right.getVal());
            sum.left = left;
            sum.right = right;
            stack.offer(sum);
        }
    }

    @Override
    public String toString() {
        return TreePrinter.asString("   ", tree.root);
    }
}
