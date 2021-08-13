package MyTools.我的数据结构;

public class TreeNodeBase<T> {
    public T val;
    public TreeNodeBase<T> left;
    public TreeNodeBase<T> right;

    public TreeNodeBase(T x) {
        val = x;
    }
}
