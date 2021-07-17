package MyTools.我的数据结构;

import java.util.Comparator;

public class MyHeap<E extends Comparable<E>> {
    Object[] elements = new Object[100];
    int size;
    Comparator<E> comparator;

    public MyHeap(Object[] elements) {
        this();
        this.elements = elements;
        size = elements.length;
        buildHeap();
    }

    public MyHeap(Object[] elements, Comparator<E> c) {
        this(c);
        this.elements = elements;
        size = elements.length;
        buildHeap();
    }

    public MyHeap(Comparator<E> c) {
        comparator = c;
    }

    public MyHeap() {
        comparator = Comparable::compareTo;
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 5, 2, 7, 3, 6, 8};
        Integer[] arr2 = {9, 5, 2, 7, 3, 6, 8};
        MyHeap<Integer> heap = new MyHeap<>();
        MyHeap<Integer> heap2 = new MyHeap<>(arr2);
        heap.offer(9);
        heap.offer(5);
        heap.offer(2);
        heap.offer(7);
        heap.offer(3);
        heap.offer(6);
        heap.offer(8);
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
        while (!heap2.isEmpty()) {
            System.out.print(heap2.poll() + " ");
        }


    }

    public void offer(E e) {
        elements[size++] = e;
        shiftUp();
    }

    @SuppressWarnings("unchecked")//抑制警告
    public E peak() {
        return size == 0 ? null : (E) elements[0];
    }

    @SuppressWarnings("unchecked")//抑制警告
    public E poll() {
        if (size == 0)
            return null;
        E ret = (E) elements[0];
        //把最后一个元素放到第一个元素 然后重新建堆
        elements[0] = elements[size - 1];
        size--;
        buildHeap();
        return ret;
    }

    @SuppressWarnings("unchecked")
//抑制警告
    void shiftDown(int parent) {
        int child = 2 * parent + 1;
        while (child < size) {
            //让child变成parent两个子节点中更小的那一个
            if (child + 1 < size && comparator.compare((E) elements[child], (E) elements[child + 1]) > 0) {
                child = child + 1;
            }
            //如果满足交换要求，交换父子节点 否则调整结束
            if (comparator.compare((E) elements[parent], (E) elements[child]) > 0) {
                Object tmp = elements[parent];
                elements[parent] = elements[child];
                elements[child] = tmp;
            } else {
                return;
            }
            parent = child;
            child = 2 * parent + 1;
        }

    }

    @SuppressWarnings("unchecked")
//抑制警告
    void shiftUp() {
        int child = size - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            //如果满足交换要求，交换父子节点 否则调整结束
            if (comparator.compare((E) elements[parent], (E) elements[child]) > 0) {
                Object tmp = elements[parent];
                elements[parent] = elements[child];
                elements[child] = tmp;
            } else {
                return;
            }
            child = parent;
            parent = (child - 1) / 2;
        }

    }

    //建堆操作 把一个不是堆的数组变成堆 从最后一个非叶子节点进行向下调整，直到调整完整个数组
    //因为是按照层序遍历存储，因此对下一层全部进行向下调整后，可以保证本层节点的所有的左右子树都是堆了，满足向下调整的进行条件————左右子树都是合法的堆
    void buildHeap() {
        if (size <= 1) {
            return;
        }
        int index = (size - 1 - 1) / 2;
        for (int i = index; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
