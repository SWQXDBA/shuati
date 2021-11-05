package MyTools.我的数据结构.数据结构实验;

import MyTools.我的数据结构.MyLinkedList;

public class 实验二链表 {
    public static void main(String[] args) {
        MyLinkedList<Integer> La = new MyLinkedList<>();
        for (int i = 1; i <= 20; i++) {
            La.add(i * 2);
        }
        System.out.println("输出单链表La");
        System.out.println(La);


        System.out.println("删除第8个结点；删除第30个结点 输出表长度");
        La.remove(7);
        La.remove(29);
        System.out.println(La.getSize());


        System.out.println("在第五个结点后插入一个结点11");
        La.insert(11, 5);
        System.out.println(La);


        System.out.println("分别查找值为28,45的元素");
        System.out.println(La.get(La.indexOf(28)) + " " + La.get(La.indexOf(45)));


        System.out.println("建立单链表Lb");
        MyLinkedList<Integer> Lb = new MyLinkedList<>();
        for (int i = 0; i <= 15; i++) {
            Lb.add(3 + i * 5);
        }
        System.out.println(Lb);


        MyLinkedList<Integer> Lc = new MyLinkedList<>();
        for (int i = 0; i < La.getSize(); i++) {
            Lc.add(La.get(i));
        }
        for (int i = 0; i < Lb.getSize(); i++) {
            Lc.add(Lb.get(i));
        }
        System.out.println("将La和Lb合并为单链表Lc");
        System.out.println(Lc);


        System.out.println("将单链表Lb按从小到大的顺序排列");
        Lb.sort(Integer::compare);
        System.out.println(Lb);


        System.out.println("输出La，Lb，Lc的以及各表的表长");
        System.out.println(La.getSize());
        System.out.println(Lb.getSize());
        System.out.println(Lc.getSize());


        System.out.println("清空单链表 再次输出表长");
        La.removeAll();
        Lb.removeAll();
        System.out.println(La.getSize());
        System.out.println(Lb.getSize());

    }
}
