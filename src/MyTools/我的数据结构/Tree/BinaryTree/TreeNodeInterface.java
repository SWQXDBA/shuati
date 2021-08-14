package MyTools.我的数据结构.Tree.BinaryTree;

public interface TreeNodeInterface<T extends Comparable<T>> {
    String getValString();

    T getVal();

    void setVal(T val);

    TreeNodeInterface<T> getLeft();

    void setLeft(TreeNodeInterface<T> left);

    TreeNodeInterface<T> getRight();

    void setRight(TreeNodeInterface<T> right);



}
