import MyTools.我的数据结构.MyHeap;

public class Main {


    public static void main(String[] args) {
        MyHeap<Integer> heap = new MyHeap<>();
        heap.offer(15);
        heap.offer(4);
        heap.offer(26);
        heap.offer(7);
        heap.offer(8);
        heap.offer(55);
        heap.offer(36);
        heap.offer(42);
        System.out.println(heap);

        heap.offer(10);
        System.out.println(heap);
    }


}

