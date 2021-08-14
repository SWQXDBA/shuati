package MyTools.我的数据结构.Tree.BinaryTree.AVLTree;

import MyTools.我的数据结构.Tree.BinaryTree.TreeNodeInterface;

class AVLTreeNode<T extends Comparable<T>> implements TreeNodeInterface<T> {
    public T val;
    public AVLTreeNode<T> parent;
    public AVLTreeNode<T> left;
    public AVLTreeNode<T> right;
    public int bf = 0;//平衡因子 -1：左子树比右子树高一层 1：右子树比左子树高一层 0：左右子树高度相同

    public AVLTreeNode(T x) {
        this.val = x;
    }

    @Override
    public String getValString() {
        return val + " bf" + bf;
    }

    @Override
    public T getVal() {
        return val;
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
        this.left = (AVLTreeNode<T>) left;
    }

    @Override
    public TreeNodeInterface<T> getRight() {
        return right;
    }

    @Override
    public void setRight(TreeNodeInterface<T> right) {
        this.right = (AVLTreeNode<T>) right;
    }


}
