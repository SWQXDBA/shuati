package MyTools.我的数据结构;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinarySearchTree<T extends Comparable<T>> {
    private TreeNodeBase<T> root;

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(11);
        tree.insert(17);
        tree.insert(24);
        tree.insert(27);
        tree.insert(1);
        tree.insert(12);
        tree.insert(16);
        tree.insert(18);
        tree.insert(23);
        tree.insert(22);
        tree.insert(26);
        tree.insert(29);


        tree.showTree("...");
        System.out.println(tree.list());
        tree.remove(11);
        tree.showTree("  ");
        System.out.println(tree.list());
        tree.remove(15);
        tree.showTree("  ");
        System.out.println(tree.list());
        tree.remove(25);
        tree.showTree("  ");
    }

    public TreeNodeBase<T> search(T key) {
        if (key == null) {
            return null;
        }
        TreeNodeBase<T> cur = root;
        while (cur != null) {
            if (key.compareTo(cur.val) > 0) {
                cur = cur.right;
            } else if (key.compareTo(cur.val) < 0) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    public TreeNodeBase<T> getMin(TreeNodeBase<T> root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNodeBase<T> getMax(TreeNodeBase<T> root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    public boolean remove(T key) {
        if (key == null) {
            return true;
        }
        TreeNodeBase<T> cur = root;
        TreeNodeBase<T> parent = cur;
        while (cur != null) {
            if (key.compareTo(cur.val) > 0) {
                parent = cur;
                cur = cur.right;
            } else if (key.compareTo(cur.val) < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                break;
            }
        }
        if (cur == null) {
            return false;
        }
        if (cur == parent.left) {
            if (cur.left == null && cur.right == null) {
                parent.left = null;
                return true;
            }
            if (cur.left == null) {
                parent.left = cur.right;
                return true;
            }
            if (cur.right == null) {
                parent.left = cur.left;
                return true;
            }
            //left!+null&&right!=null
            TreeNodeBase<T> rightMin = getMin(cur.right);
            rightMin.left = cur.left;
            parent.left = cur.right;
        }


        if (cur == parent.right) {
            if (cur.left == null && cur.right == null) {
                parent.right = null;
                return true;
            }
            if (cur.left == null) {
                parent.right = cur.right;
                return true;
            }
            if (cur.right == null) {
                parent.right = cur.left;
                return true;
            }
            //left!+null&&right!=null
            TreeNodeBase<T> rightMin = getMin(cur.right);
            rightMin.left = cur.left;
            parent.right = cur.right;
        }


        return false;
    }

    public void insert(T key) {
        if (key == null) {
            return;
        }
        if (root == null) {
            root = new TreeNodeBase<T>(key);
            return;
        }

        TreeNodeBase<T> cur = root;
        TreeNodeBase<T> parent = cur;
        while (cur != null) {
            if (key.compareTo(cur.val) > 0) {
                parent = cur;
                cur = cur.right;
            } else if (key.compareTo(cur.val) < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        if (key.compareTo(parent.val) > 0) {
            parent.right = new TreeNodeBase<T>(key);
        } else {
            parent.left = new TreeNodeBase<T>(key);
        }
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        getListHelper(list, root);
        return list;
    }

    private void getListHelper(List<T> list, TreeNodeBase<T> root) {
        if (root == null)
            return;
        getListHelper(list, root.left);
        list.add(root.val);
        getListHelper(list, root.right);
    }

    public void showTree(String raw) {

        if (root == null) {
            System.out.println("Tree is null.");
            return;
        }
        Queue<TreeNodeBase<T>> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 1;//当前层数
        int deep = deep(root);
        while (!queue.isEmpty() && curLevel <= deep) {
            int length = (int) (Math.pow(2, (deep - curLevel)) - 1);
            //每一层最前面的空格
            for (int j = 0; j <= length + 1; j++) {
                System.out.print(raw);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeBase<T> cur = queue.poll();
                if (cur == null) {
                    for (int j = 0; j <= length * 2 + 1; j++) {
                        System.out.print(raw);
                    }
                    queue.offer(null);
                    queue.offer(null);
                    continue;
                }
                //节点不为null
                System.out.print(cur.val);
                int t = raw.length() - (cur.val.toString().length());
                //补足数据长度和占位符的差值
                for (int j = 0; j < t; j++) {
                    System.out.print(raw.charAt(0));
                }
                //两个节点之间的占位符
                for (int j = 0; j <= length * 2; j++) {
                    System.out.print(raw);
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            System.out.println("\n");
            curLevel++;
        }
    }

    private int deep(TreeNodeBase<T> root) {
        return root == null ? 0 : Math.max(deep(root.left), deep(root.right)) + 1;
    }



}
