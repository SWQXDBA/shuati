package MyTools.我的数据结构.Tree.BinaryTree.AVLTree;

import MyTools.我的数据结构.Tree.BinaryTree.BinaryTreeInterface;

//只实现了增加
public class AVLTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {
    AVLTreeNode<T> root;

    void clean() {
        root = null;
    }

    @Override
    public void insert(T val) {

        if (root == null) {
            root = new AVLTreeNode<>(val);
            return;
        }
        AVLTreeNode<T> currentRoot = root;
        AVLTreeNode<T> currentSon = root;
        while (currentSon != null) {
            if (val.compareTo(currentSon.val) < 0) {
                currentRoot = currentSon;
                currentSon = currentRoot.left;

                continue;
            }

            if (val.compareTo(currentSon.val) > 0) {
                currentRoot = currentSon;
                currentSon = currentRoot.right;
                continue;
            } else {
                //已经有这个元素了
                return;
            }
        }
        if (val.compareTo(currentRoot.val) < 0) {
            currentRoot.left = new AVLTreeNode<>(val);
            currentRoot.left.parent = currentRoot;
            currentRoot = currentRoot.left;
        } else {
            currentRoot.right = new AVLTreeNode<>(val);
            currentRoot.right.parent = currentRoot;
            currentRoot = currentRoot.right;
        }
        //插入完成 现在开始调整

        //调整平衡因子
        AVLTreeNode<T> parent = currentRoot.parent;
        while (parent != null) {
            //调整本子树的平衡因子
            if (currentRoot == parent.left) {
                parent.bf--;
            } else {
                parent.bf++;
            }

            if (parent.bf == 0) { //该子树的高度不变 无需更新父节点
                return;
            } else if (parent.bf == -1 || parent.bf == 1) {//该子树的高度被改变了，需要向上逐层更新
                currentRoot = parent;
                parent = parent.parent;
                continue;
            }
            //Parent与其较高子树节点的平衡因子时同号时单旋转，异号时双旋转。
            if (parent.bf == 2) {//需要左旋
                if (parent.right.bf == 1) {
                    rotateLeft(parent);
                } else {
                    rotateRightLeft(parent);
                }
            } else {//bf==-2 需要右旋
                if (parent.left.bf == -1) {
                    rotateRight(parent);
                } else {
                    rotateLeftRight(parent);
                }
            }
            break;
        }
    }

    @Override
    public T get(T key) {
        return search(root, key);
    }

    @Override
    public boolean remove(T v) {
        return false;
    }

    private void rotateRight(AVLTreeNode<T> parent) {//右旋 将parent下调一层 parent.left上调一层
        AVLTreeNode<T> pParent = parent.parent;
        AVLTreeNode<T> sub = parent.left;
        AVLTreeNode<T> subR = sub.right;

        parent.left = subR;
        if (subR != null)
            subR.parent = parent;

        sub.right = parent;
        parent.parent = sub;


        sub.parent = pParent;
        if (parent != root) {//root.parent==null
            if (parent == pParent.left) {
                pParent.left = sub;
            } else {
                pParent.right = sub;
            }
        } else {
            root = sub;
        }
        parent.bf = 0;
        sub.bf = 0;
    }

    private void rotateLeft(AVLTreeNode<T> parent) {//左旋 将parent下调一层 parent.right上调一层
        AVLTreeNode<T> pParent = parent.parent;
        AVLTreeNode<T> sub = parent.right;
        AVLTreeNode<T> subL = sub.left;

        parent.right = subL;
        if (subL != null)
            subL.parent = parent;

        sub.left = parent;
        parent.parent = sub;

        sub.parent = pParent;
        if (parent != root) {
            if (parent == pParent.left) {
                pParent.left = sub;
            } else {
                pParent.right = sub;
            }
        } else {
            root = sub;
        }
        sub.bf = 0;
        parent.bf = 0;
    }

    private void rotateLeftRight(AVLTreeNode<T> parent) {//左旋再右旋 此时parent.bf ==-2
        AVLTreeNode<T> sub = parent.left;
        AVLTreeNode<T> subR = sub.right;
        int bf = subR.bf;
        rotateLeft(sub);
        rotateRight(parent);

        //此时三个节点的bf都为0 是不正确的 要根据插入节点的位置重新更新
        if (bf == -1) {//新节点加到了subR的左边
            // sub.bf = 0;
            parent.bf = 1;
        } else if (bf == 1) {// 新节点加到了subR的右边
            sub.bf = -1;
            //  parent.bf = 0;
        }
//        }else if(bf==0){
//            //说明subR为叶子节点 左右子树都为空
//        }
    }

    private void rotateRightLeft(AVLTreeNode<T> parent) {//右旋再左旋 此时parent.bf ==2


        AVLTreeNode<T> sub = parent.right;
        AVLTreeNode<T> subL = sub.left;
        int bf = subL.bf;
        rotateRight(sub);
        rotateLeft(parent);


        if (bf == 1) {
            parent.bf = -1;
        } else if (bf == -1) {
            sub.bf = 1;
        }

    }
}
