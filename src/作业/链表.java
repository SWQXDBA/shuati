package 作业;

import MyTools.我的数据结构.MyLinkedList;

public class 链表 {
    public static void main(String[] args) {
        MyLinkedList<student> list = new MyLinkedList<>();
        student stu1 = new student("小明", 18);
        student stu2 = new student("李华", 128);
        student stu3 = new student("康康", 138);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        student stu4 = new student("头插", 1);
        list.addToFirst(stu4);
        System.out.println(list);
        System.out.println("list.getSize():  " + list.getSize());
        System.out.println("list.getFirst():  " + list.getFirst());
        System.out.println("list.getLast():  " + list.getLast());
        System.out.println("list.indexOf():  " + list.indexOf(stu1));

        list.remove(stu4);
        System.out.println(list);
        list.removeAll();
        System.out.println(list);
    }

    static class student {
        String name;
        int age;

        public student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
