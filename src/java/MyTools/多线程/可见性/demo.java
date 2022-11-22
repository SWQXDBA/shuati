package MyTools.多线程.可见性;

public class demo {
    static boolean bool = true;

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            while (bool) {
                System.out.println("..");//会破坏不可见性
                //因为调用了synchronized 解锁前会将本地内存修改的内容刷新到主内存中
                //因为调用了synchronized 单独使用以下注释的代码同理


//                            synchronized (Thread.currentThread()){
//                            }

            }
        });
        t1.start();
        try {
            Thread.sleep(1000);
            bool = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
