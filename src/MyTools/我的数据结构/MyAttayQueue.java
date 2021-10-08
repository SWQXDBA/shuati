package MyTools.我的数据结构;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyAttayQueue<E> implements Queue<E> {
    int head = 0;//head出来
    int tail = 0;//tail进入
    private Object[] elements = null;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
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
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
