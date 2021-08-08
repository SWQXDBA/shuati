package MyTools.多线程.CAS;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class 原子更新器 {
    public static void main(String[] args) {
        Person p = new Person();
        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Person.class, String.class, "name");
        updater.compareAndSet(p, null, "小明");
        System.out.println(p);
    }
}

class Person {
    volatile String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

