package 作业;

public class 链表 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.addToFirst(66);
        System.out.println(list);
        System.out.println("list.getSize():  " + list.getSize());
        System.out.println("list.getFirst():  " + list.getFirst());
        System.out.println("list.getLast():  " + list.getLast());

        System.out.println("list.indexOf(3):  " + list.indexOf(3));
    }


}
