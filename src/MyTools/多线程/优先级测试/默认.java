package MyTools.多线程.优先级测试;

import MyTools.多线程.自己的线程池1.MyThreadPool;

public class 默认 {
    //设置优先级或者yield对于cpu空闲的情况下效果不明显
    public static void main(String[] args) {
        final int cnt = 10000;
        //让cpu满载
        MyThreadPool.pressTest(10000);
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < cnt; i++) {
                System.out.println("1threadt  " + i);
            }
        });
        Thread t2 = new Thread(() -> {

            for (int i = 0; i < cnt; i++) {
                System.out.println("        2threadt  " + i);
            }
        });
        t1.start();
        System.out.println("第二线程开始了");
        t2.start();
    }
}
