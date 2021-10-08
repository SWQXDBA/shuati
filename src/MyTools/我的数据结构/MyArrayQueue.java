package MyTools.我的数据结构;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyArrayQueue<E> implements Queue<E> {
    int head = 0;//head出来
    int tail = 0;//tail进入
    private Object[] elements = null;

    public MyArrayQueue() {
        elements = new Object[5];
    }

    public static void main(String[] args) {
        //0 1 2 3 4
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
        queue.add(1);
        System.out.println(queue.size());
        queue.add(2);
        System.out.println(queue.size());
        queue.add(3);
        System.out.println(queue.size());
        queue.add(4);
        System.out.println(queue.size());
        queue.add(5);
        System.out.println(queue.size());
        queue.add(6);
        System.out.println(queue.size());
        queue.remove();
        System.out.println(queue.size());
        queue.remove();
        System.out.println(queue.size());
        queue.add(5);
        System.out.println(queue.size());
        queue.add(6);
        System.out.println(queue.size());


    }

    @Override
    public String toString() {
        return "MyArrayQueue{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    @Override
    public int size() {
        //0 1 2 3 4
        if (tail < head) {
            return tail + elements.length - head;
        }
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private int movePrev(int start) {
        return (start + elements.length - 1) % elements.length;
    }

    private int moveNext(int start) {
        return (start + 1) % elements.length;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        int ptr = head;
        while (ptr != tail) {
            if (elements[ptr].equals(o))
                return true;
            ptr = moveNext(ptr);
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return Arrays.copyOf(a, elements.length);
    }

    @Override
    public boolean add(E e) {
        if (moveNext(tail) == head) {
            grow();
            add(e);
        } else {
            elements[tail] = e;
            tail = moveNext(tail);
        }
        return true;
    }

    public void grow() {
        int newSize = (int) (elements.length * 1.5);
        int oldTail = tail;
        int oldHead = head;
        tail = 0;
        head = 0;
        Object[] oldArray = elements;
        elements = new Object[newSize];
        int ptr = oldHead;
        while (ptr != oldTail) {
            add((E) oldArray[ptr++]);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("o==null");
        }
        int ptr = head;
        while (ptr != tail) {
            if (o.equals(elements[ptr])) {
                elements[ptr] = null;
                //搬运
                while (ptr != tail) {
                    elements[ptr] = elements[moveNext(ptr)];
                    ptr++;
                    tail = movePrev(tail);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        for (Object o : c) {
            flag = flag && contains(o);
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        elements = new Object[10];
        tail = 0;
        head = 0;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        E e = (E) elements[head];
        elements[head] = null;
        head = moveNext(head);

        return e;
    }

    @Override
    public E poll() {
        return remove();
    }

    @Override
    public E element() {
        return peek();
    }


    @Override
    public E peek() {
        return (E) elements[head];
    }
}
