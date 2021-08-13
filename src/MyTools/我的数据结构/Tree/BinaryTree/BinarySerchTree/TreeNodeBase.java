package MyTools.我的数据结构.Tree.BinaryTree.BinarySerchTree;

import MyTools.我的数据结构.Tree.BinaryTree.TreeNodeInterface;

public class TreeNodeBase<T extends Comparable<T>> implements TreeNodeInterface<T> {
    public T val;
    public TreeNodeBase<T> left;
    public TreeNodeBase<T> right;

    public TreeNodeBase(T x) {
        val = x;
    }

    @Override
    public String getVal() {
        return val + "";
    }

    @Override
    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public TreeNodeInterface<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(TreeNodeInterface<T> left) {
        this.left = (TreeNodeBase<T>) left;
    }

    @Override
    public TreeNodeInterface<T> getRight() {
        return right;
    }

    @Override
    public void setRight(TreeNodeInterface<T> right) {
        this.right = (TreeNodeBase<T>) right;
    }
}
