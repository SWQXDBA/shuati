package MyTools.多线程.守护线程;

public class 守护线程 {
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
        Thread t2 = new Thread(() -> {

            while (true) {
                try {
                    System.out.println("t2运行中");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            //由于强制终止 本条语句应该不会被打印
            System.out.println("守护线程结束");
        });
        //在所有非守护线程结束后 守护线程强制结束
        t2.setDaemon(true);
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("主线程结束");
    }
}
