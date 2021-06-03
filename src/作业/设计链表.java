package 作业;

public class 设计链表 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);

        System.out.println(list);
    }

    static class MyLinkedList {
        Node head;
        Node end;
        int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

        }

        private Node getNode(int index) {
            if (size == 0 || index >= size)
                return null;
            Node go = head;
            for (int i = 0; i < index; i++) {
                go = go.next;
            }
            return go;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            Node n = getNode(index);
            if (n == null)
                return -1;

            return n.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node thead = head;
            head = new Node(val);
            head.next = thead;
            if (thead != null)
                head.next.prev = head;
            size++;
            if (size == 1)
                end = head;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (size == 0) {
                addAtHead(val);
                return;
            }

            end.next = new Node(val);
            end.next.prev = end;
            end = end.next;
            size++;

        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            if (index > size)
                return;
            Node n = getNode(index);
            Node prev = n.prev;
            Node newNode = new Node(val);
            prev.next = newNode;
            n.prev = newNode;

            newNode.next = n;
            newNode.prev = prev;

            size++;

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size || size == 0)
                return;
            Node n = getNode(index);
            if (n == head) {
                size--;
                head = head.next;
                if (size == 0) {
                    end = null;
                }
                return;
            }
            if (n == end) {
                size--;
                end = end.prev;
                end.next = null;
                return;
            }
            n.next.prev = n.prev;
            n.prev.next = n.next;
            size--;

        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node t = head;
            while (t != null) {
                stringBuilder.append(t.val);
                stringBuilder.append(",");
                t = t.next;
            }
            return stringBuilder.toString();
        }

        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }
    }

}
