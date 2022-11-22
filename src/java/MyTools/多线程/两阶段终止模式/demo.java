package MyTools.多线程.两阶段终止模式;

public class demo {


    public static void main(String[] args) {

        //模拟守护线程
        //interrupt()会设置当前线程的打断状态为true 但 不!一!定! 会抛出InterruptedException
        //只有当线程在 wait(), wait(long),ait(long, int) join(), join(long), join(long, int), sleep(long), or sleep(long, int)
        //等方法（处于阻塞状态）中被打断(isInterrupted == true) 会立刻清空打断标记(令isInterrupted = false)  并且抛出InterruptedException
        // 此时需要再次调用interrupt()恢复打断标记
        //若不处于阻塞状态 则interrupt()只会令(isInterrupted = true) 不会抛出InterruptedException异常

        //自己的思考: 在sleep中被打断不一定要真的结束 所以如果此时不清空打断标记就一定会被下一个判断 if(isInterrupted)处拦截
        Thread t1 = new Thread(() -> {
            int loop = 1;
            while (true) {
                int i = 0;
                for (int j = 0; j < 90000000; j++) {
                    for (int k = 0; k < 90000000; k++) {
                        i++;
                    }
                    i--;
                }
                System.out.println("第" + (loop++) + "次循环" + i);


                try {
                    if (Thread.currentThread().isInterrupted()) {
                        //料理后事
                        System.out.println("被终止了");
                        return;
                    }
                    System.out.println("进入休眠");
                    Thread.sleep(5000);
                    System.out.println("打印守护日志");
                    //do something
                } catch (InterruptedException e) {
                    System.out.println("sleep中收到异常 即将进行终止 此时清除了打断标记" + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();//清除打断标记
                    System.out.println("恢复打断标记" + Thread.currentThread().isInterrupted());
                }

            }

        });

        t1.start();
        try {

            System.out.println("线程未进入休眠 所以未被打断" + t1.isInterrupted());//false 未进入sleep
            Thread.sleep(1000);
            System.out.println("休眠没有被打断" + t1.isInterrupted());//false 因为没有被打断


            t1.interrupt();//打断等待 设置打断标记为true
            System.out.println("休眠被打断了" + t1.isInterrupted());//true 因为调用了interrupt()


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
