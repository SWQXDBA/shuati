import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Box<Person> box = new Box<>();
        box.add(new Person("小明"));
        box.add(new Person("小王"));
        for (var i : box) {
            System.out.println(i);
        }

    }

    static class Box<E> implements Iterable<E> {
        int size = 0;
        Object[] values;

        public Box() {
            values = new Object[100];
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


}

