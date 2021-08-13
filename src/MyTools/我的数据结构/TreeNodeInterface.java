package MyTools.我的数据结构;

public interface TreeNodeInterface<T extends Comparable<T>> {
    T getVal();

    void setVal(T val);

    TreeNodeInterface<T> getLeft();

    void setLeft(TreeNodeInterface<T> left);

    TreeNodeInterface<T> getRight();

    void setRight(TreeNodeInterface<T> right);

}
