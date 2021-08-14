package MyTools.我的数据结构.Tree.BinaryTree;

public interface BinaryTreeInterface<T extends Comparable<T>> {

    void insert(T v);

    T get(T v);

    boolean remove(T v);

    default T search(TreeNodeInterface<T> root, T key) {
        if (key == null) {
            return null;
        }
        var cur = root;
        while (cur != null) {
            if (key.compareTo(cur.getVal()) > 0) {
                cur = cur.getRight();
            } else if (key.compareTo(cur.getVal()) < 0) {
                cur = cur.getLeft();
            } else {
                return cur.getVal();
            }
        }
        return null;

    }
}
