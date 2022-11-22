package 作业;

public class 实现单向链表 {
    class NodeList {
        Node head;

        void add(int val) {
            Node temp = head;
            if (temp == null) {
                head = new Node(val);
                return;
            }

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);

        }

        int remove() {
            Node temp = head;
            if (temp == null)
                return -1;
            if (temp.next == null) {
                head = null;
                return -1;
            }
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int ret = temp.next.val;
            temp.next = null;
            return ret;

        }

        class Node {
            int val;
            Node next;

            Node(int i) {
                val = i;
            }
        }


    }


}
