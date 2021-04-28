package 作业;

public class MyLinkedList<T> {
    private int size = 0;
    private Node<T> firstNode;
    private Node<T> lastNode;

    private void LinkToFirst(T item) {
        Node<T> oldFirst = firstNode;
        Node<T> newNode = new Node<>(item, null, oldFirst);
        firstNode = newNode;
        if (oldFirst == null) {
            lastNode = newNode;
        } else {
            oldFirst.prev = newNode;
        }
        size++;
    }

    private void LinkToEnd(T item) {
        Node<T> oldLast = lastNode;
        Node<T> newNode = new Node<>(item, lastNode, null);
        lastNode = newNode;
        if (oldLast == null) {
            firstNode = newNode;
        } else {
            oldLast.next = newNode;
        }
        size++;
    }

    private void LinkBefore(T item, Node<T> loc) {
        if (loc.prev == null) {
            LinkToFirst(item);
            return;
        }
        Node<T> newNode = new Node<>(item, loc.prev, loc);
        loc.prev.next = newNode;
        loc.prev = newNode;
        size++;
    }

    private T unLinkFirst() {
        if (size == 0)
            return null;
        T ret = firstNode.value;
        firstNode.value = null;
        firstNode = firstNode.next;
        if (firstNode == null) {
            lastNode = null;
        } else {
            firstNode.prev.next = null;
            firstNode.prev = null;
        }
        size--;
        return ret;
    }

    private T unLinkLast() {
        if (size == 0)
            return null;
        T ret = lastNode.value;
        lastNode.value = null;
        lastNode = lastNode.prev;
        if (lastNode == null) {
            firstNode = null;
        } else {
            lastNode.next.prev = null;
            lastNode.next = null;
        }
        size--;
        return ret;
    }

    private T unLink(Node<T> node) {
        //注意不要用equals
        if (node == firstNode)
            return unLinkFirst();

        if (node == lastNode)
            return unLinkLast();

        T ret = node.value;
        Node<T> pr = node.prev;
        Node<T> ne = node.next;

        node.value = null;
        node.prev = null;
        node.next = null;

        pr.next = ne;
        ne.prev = pr;
        size--;
        return ret;
    }

    public void add(T item) {
        LinkToEnd(item);
    }

    public void addToFirst(T item) {
        LinkToFirst(item);
    }

    public T getFirst() {
        return firstNode.value;
    }

    public T getLast() {
        return lastNode.value;
    }

    public T removeFirst() {
        return unLinkFirst();
    }

    public T removeLast() {
        return unLinkLast();
    }

    public boolean remove(T item) {
        if (item == null) {
            for (Node<T> x = firstNode; x != null; x = x.next) {
                if (x.value == null) {
                    unLink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = firstNode; x != null; x = x.next) {
                if (x.value.equals(item)) {
                    unLink(x);
                    return true;
                }
            }
        }
        return false;

    }

    public boolean removeAll() {
        if (size == 0)
            return false;
        for (Node<T> x = firstNode; x != null; x = x.next) {
            unLink(x);
        }
        return true;
    }

    public int indexOf(T item) {
        int index = 0;
        if (size == 0)
            return -1;
        if (item == null) {
            for (Node<T> x = firstNode; x != null; x = x.next) {
                if (x.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> x = firstNode; x != null; x = x.next) {
                if (x.value.equals(item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;

    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Node<T> x = firstNode; x != null; x = x.next) {
            stringBuilder.append(x.value);
            if (x.next != null)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
