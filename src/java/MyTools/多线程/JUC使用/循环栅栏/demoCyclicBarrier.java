package MyTools.多线程.JUC使用.循环栅栏;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demoCyclicBarrier {
    public static void main(String[] args) {
        //当计数为0时 执行任务 可以修改计数 解决了倒计时锁无法重置计数每次需要new新的CountDownLatch的问题
        //当计数为0后 再次调用会重置次数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            Debugger.debug("all finish");//在计数为0后执行此任务
        });//初始计数为10
        ExecutorService service = Executors.newFixedThreadPool(6);


        service.execute(() -> {
            Sleeper.sleep(1000);
            try {
                Debugger.debug("阻塞等待");
                cyclicBarrier.await();//每调用一次 计数-1 返回值为剩余的计数
                Debugger.debug("执行成功" + cyclicBarrier.getParties());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        service.execute(() -> {
            Sleeper.sleep(2000);
            try {
                Debugger.debug("阻塞等待");
                cyclicBarrier.await();//每调用一次 计数-1
                Debugger.debug("执行成功" + cyclicBarrier.getParties());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        service.execute(() -> {
            Sleeper.sleep(2000);
            try {
                Debugger.debug("阻塞等待");
                cyclicBarrier.await();//每调用一次 计数-1
                Debugger.debug("执行成功" + cyclicBarrier.getParties());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });


    }
}
