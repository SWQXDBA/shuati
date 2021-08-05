package MyTools.多线程.线程的状态;

public class 阻塞演示 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {

            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {

            }
        });
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t5 = new Thread(() -> {
            synchronized (阻塞演示.class) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t6 = new Thread(() -> {
            synchronized (阻塞演示.class) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            Thread.sleep(100);//保证t5先获得锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());//NEW 因为没有start
        System.out.println(t2.getState());//RUNNABLE 正在运行
        System.out.println(t3.getState());//TIMEWAITING 在等待sleep结束
        System.out.println(t4.getState());//WAITING 等待t3.join
        System.out.println(t5.getState());//TIMEWAITING 在等待sleep结束
        System.out.println(t6.getState());//BLOCKED 等待t5释放锁
    }
}
