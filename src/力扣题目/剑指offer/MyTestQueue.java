package 力扣题目.剑指offer;

public class MyTestQueue<E> {
    Node<E> val;

    public void fun1(E e) {
        val = new Node<>(e);
    }

    public boolean fun2(E e) {
        fun3(e);
        return false;
    }

    private void fun3(E e) {
        val = new Node<>(e);
    }

    class Node<E> {
        E val;

        public Node(E val) {
            this.val = val;
        }
    }
}
