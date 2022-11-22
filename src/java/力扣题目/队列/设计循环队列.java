package 力扣题目.队列;

public class 设计循环队列 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(81); // 设置长度为 3
        circularQueue.enQueue(69);
        circularQueue.deQueue();
        circularQueue.enQueue(92);
        circularQueue.enQueue(12);
        circularQueue.deQueue();
        circularQueue.isFull();
        circularQueue.isFull();
        System.out.println(circularQueue.Front());


    }

    static class MyCircularQueue {
        int[] values;
        int head;
        int tail;
        int size = 0;

        public MyCircularQueue(int k) {
            values = new int[k];
            head = 0;
            tail = 0;
        }

        private int next(int v) {
            if (v < values.length - 1) {
                return v + 1;
            } else {
                return 0;
            }
        }

        public boolean enQueue(int value) {
            if (size == values.length)
                return false;
            if (size == 0) {
                values[tail] = value;
                size++;
                return true;
            } else {
                tail = next(tail);
                values[tail] = value;
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (size == 0)
                return false;
            if (size != 1)
                head = next(head);
            size--;
            return true;
        }

        public int Front() {
            if (size == 0)
                return -1;
            return values[head];
        }

        public int Rear() {
            if (size == 0)
                return -1;
            return values[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == values.length;
        }
    }
}
