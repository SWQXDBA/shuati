package 力扣题目.剑指offer;

public class 剑指36 {

    static Node buildHelper(Node root) {
        if (root.left != null) {
            Node left = buildHelper(root.left);
            left.right = root;
            root.left = left;
        }
        if (root.right != null) {
            Node rightHead = getHead(root.right);
            Node rightEnd = buildHelper(root.right);
            root.right = rightHead;
            rightHead.left = root;
            return rightEnd;
        }
        return root;
    }

    static Node getHead(Node root) {
        Node head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    static Node getend(Node root) {
        Node end = root;
        while (end.right != null) {
            end = end.right;
        }
        return end;
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node head = null;
        if (root.left == null)
            head = root;
        else {
            head = getHead(root);
        }
        Node end = null;
        if (root.right == null)
            end = root;
        else {
            end = getend(root);
        }
        buildHelper(root);
        end.right = head;
        head.left = end;
        return head;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
