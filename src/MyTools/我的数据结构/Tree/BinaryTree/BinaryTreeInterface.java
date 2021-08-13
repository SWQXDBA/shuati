package MyTools.我的数据结构.Tree.BinaryTree;

public interface BinaryTreeInterface<T extends Comparable<T>> {

    void insert(T v);

    T get(T v);

    boolean remove(T v);
}
