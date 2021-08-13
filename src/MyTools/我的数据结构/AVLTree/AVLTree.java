package MyTools.我的数据结构.AVLTree;

public class AVLTree<T extends Comparable<T>> {
    AVLTreeNode<T> root;

    public void insert(T val) {

        if (root == null) {
            root = new AVLTreeNode<>(val);
            return;
        }
        AVLTreeNode<T> currentRoot = root;
        AVLTreeNode<T> currentSon = root;
        while (currentSon != null) {
            if (val.compareTo(currentSon.getVal()) < 0) {
                currentRoot = currentSon;
                currentSon = currentRoot.left;

                continue;
            }
            if (val.compareTo(currentSon.getVal()) > 0) {
                currentRoot = currentSon;
                currentSon = currentRoot.right;
                continue;
            } else {
                //已经有这个元素了
                return;
            }
        }
        if (val.compareTo(currentRoot.getVal()) < 0) {
            currentRoot.left = new AVLTreeNode<>(val);
        } else {
            currentRoot.right = new AVLTreeNode<>(val);
        }


    }
}
