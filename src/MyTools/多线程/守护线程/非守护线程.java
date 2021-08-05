package MyTools.多线程.守护线程;

public class 非守护线程 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("t1运行中");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            System.out.println("t1结束");
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }
}
