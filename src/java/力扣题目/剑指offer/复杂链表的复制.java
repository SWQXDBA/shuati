package 力扣题目.剑指offer;

public class 复杂链表的复制 {
    public int getIndexInList(Node head, Node target) {
        int i = 0;
        while (head != target) {
            head = head.next;
            i++;

        }
        return i;
    }

    public Node getNode(Node head, int index) {
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    public Node copyRandomList(Node head) {

        if (head == null) return null;
        Node current = head;
        Node head2 = new Node(head.val);
        Node current2 = head2;
        current = current.next;
        while (current != null) {
            current2.next = new Node(current.val);
            current2 = current2.next;
            current = current.next;
        }
        current2 = head2;
        current = head;
        while (current != null) {
            if (current.random == null) {
                current = current.next;
                current2 = current2.next;
                continue;
            }
            int indexInList = getIndexInList(head, current.random);
            current2.random = getNode(head2, indexInList);
            current = current.next;
            current2 = current2.next;
        }
        return head2;

    }

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
