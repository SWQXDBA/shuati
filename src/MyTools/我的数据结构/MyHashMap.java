package MyTools.我的数据结构;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;//初始容量
    static final float DEFAULT_LOAD_FACTOR = 0.75f;//负载因子
    int resizeTime = 0;
    @SuppressWarnings({"unchecked"})
    Node<K, V>[] table = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
    int size;
    int capacity;
    Set<MyEntry<K, V>> entrySet;

    public MyHashMap() {
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public Set<MyEntry<K, V>> entrySet() {
        if (entrySet != null) {
            return entrySet;
        }
        entrySet = new HashSet<>();//用来取代HashIterator 这里不做复杂实现 仅提供遍历元素的功能
        for (Node<K, V> node : table) {
            if (node != null) {
                entrySet.addAll(node.list);
            }
        }
        return entrySet;
    }

    public int getSize() {
        return size;
    }

    public int getResizeTime() {
        return resizeTime;
    }

    @SuppressWarnings({"unchecked"})
    private void resize() {
        //判断是否需要扩容

        if (size < capacity * DEFAULT_LOAD_FACTOR) {
            return;
        }
        resizeTime++;
        Node<K, V>[] old = table;
        capacity = capacity * 2;
        size = 0;
        //弄一个新数组 再用put()把元素全部扔进去
        table = (Node<K, V>[]) new Node[capacity];
        for (Node<K, V> node : old) {
            if (node != null) {
                for (MyEntry<K, V> entry : node.list) {
                    put(entry.getKey(), entry.getValue());
                }
            }
        }


    }

    private int hash(K key) {
        //下标范围为(0,capacity - 1)
        return key.hashCode() & (capacity - 1);
    }

    private MyEntry<K, V> getEntryFromList(K key) {
        int hash = hash(key);
        if (hash >= capacity) {
            return null;
        }
        if (table[hash] == null) {
            return null;
        }
        for (MyEntry<K, V> entry : table[hash].list) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    public V get(K key) {
        MyEntry<K, V> entry = getEntryFromList(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public void put(K key, V value) {
        MyEntry<K, V> entry = getEntryFromList(key);
        if (entry == null) {
            putNew(new MyEntry<>(key, value));
            size++;
            resize();
        } else {
            entry.setValue(value);
        }

    }

    private void putNew(MyEntry<K, V> entry) {
        int hash = hash(entry.getKey());

        if (table[hash] == null) {
            table[hash] = new Node<>();
            table[hash].hash = hash;
        }
        table[hash].list.add(entry);
    }

    public void remove(K key) {
        int hash = hash(key);

        if (table[hash] == null) {
            System.out.println("没找到");
            return;
        }
        if (table[hash].list.remove(getEntryFromList(key))) {
            size--;
        }
    }

    static class Node<K, V> {
        //LinkedList<MyEntry<K,V>>
        int hash;
        LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    }

    static class MyEntry<K, V> {
        K key;
        V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @SuppressWarnings({"unchecked"})
        @Override
        public boolean equals(Object obj) {
            MyEntry<K, V> o = (MyEntry<K, V>) obj;
            return key.equals(o.getKey()) && value.equals(o.getValue());
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<TestObj, Integer> map = new MyHashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put(new TestObj("小明" + i, i + 2), i);
        }
        for (int i = 0; i < 50; i++) {
            map.remove(new TestObj("小明" + i, i + 2));
        }
        System.out.println(map.resizeTime);
        System.out.println(map.size);
        System.out.println(map.capacity);


        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + "::" + e.getValue());
        }

        MyHashMap<Integer, Integer> map1 = new MyHashMap<>();
        for (int i = 0; i < 5; i++) {
            map1.put(i, i);
        }
        for (int i = 0; i < 5; i++) {
            map1.remove(i);
        }
        System.out.println(map1.size);
    }

}
