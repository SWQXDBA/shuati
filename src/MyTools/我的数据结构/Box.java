package MyTools.我的数据结构;


import java.util.Iterator;

//想要让foreach可以作用，需要实现Iterable接口 Iterable接口需要返回一个迭代器Iterator对象 迭代器对象则由一个内部类实现。
//Iterator需要有hasNext()和next()
public class Box<E> implements Iterable<E> {
    int size = 0;
    Object[] values;

    public Box() {
        values = new Object[100];
    }

    public static void main(String[] args) {
        Box<Person> box = new Box<>();
        box.add(new Person("小明"));
        box.add(new Person("小王"));
        for (var i : box) {
            System.out.println(i);
        }

    }

    public void add(E val) {
        values[size++] = val;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) values[index];
    }

    @Override

    public Iterator<E> iterator() {
        return new Itr(this);
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class Itr implements Iterator<E> {
        Box<E> box;
        int currentIndex = 0;

        public Itr(Box<E> box) {
            this.box = box;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < box.size;
        }

        @Override
        public E next() {
            return box.get(currentIndex++);
        }
    }


}
