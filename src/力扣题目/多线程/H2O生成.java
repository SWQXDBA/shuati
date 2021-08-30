package 力扣题目.多线程;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class H2O生成 {
    public static void main(String[] args) {
        var pool = Executors.newFixedThreadPool(3);
        var h2o = new H2O();
        pool.execute(() -> {
            try {
                h2o.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        pool.execute(() -> {
            try {
                h2o.oxygen(() -> System.out.println("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        pool.execute(() -> {
            try {
                h2o.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        pool.shutdown();

    }

    static class H2O {
        Semaphore hydrogenSemaphore = new Semaphore(2);
        Semaphore oxygenSemaphore = new Semaphore(2);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hydrogenSemaphore.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            oxygenSemaphore.release();//每个H给O添加一个许可
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oxygenSemaphore.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            hydrogenSemaphore.release(2);//每个O给H添加二个许可
        }
    }
//    static class H2O {
//       volatile static AtomicInteger oxygenCount = new AtomicInteger(0);
//       volatile static AtomicInteger hydrogenCount = new AtomicInteger(0);
//        volatile static AtomicInteger releasedOxygenCount = new AtomicInteger(0);
//        volatile static AtomicInteger releasedHydrogenCount = new AtomicInteger(0);
//        static ReentrantLock lock = new ReentrantLock();
//        public H2O() {
//
//        }
//
//        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//            hydrogenCount.incrementAndGet();
//            while(!((releasedHydrogenCount.get()!=0||releasedOxygenCount.get()!=0)||hydrogenCount.get()>=2&&oxygenCount.get()>=1)){
//
//            }
//            lock.lock();
//            if((releasedHydrogenCount.get()!=0||releasedOxygenCount.get()!=0)||hydrogenCount.get()>=2&&oxygenCount.get()>=1){
//                if(releasedHydrogenCount.get()<2){
//                    // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//                    releaseHydrogen.run();
//                    hydrogenCount.decrementAndGet();
//                    releasedHydrogenCount.incrementAndGet();
//                    if(releasedOxygenCount.get()==1&&releasedHydrogenCount.get()==2){
//                        releasedOxygenCount = new AtomicInteger(0);
//                        releasedHydrogenCount = new AtomicInteger(0);
//                    }
//                    lock.unlock();
//                    return;
//                }
//            }
//            hydrogenCount.decrementAndGet();
//            lock.unlock();
//            hydrogen(releaseHydrogen);
//
//        }
//
//        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//            oxygenCount.incrementAndGet();
//            while(!((releasedHydrogenCount.get()!=0||releasedOxygenCount.get()!=0)||hydrogenCount.get()>=2&&oxygenCount.get()>=1)){
//
//            }
//            lock.lock();
//            if((releasedHydrogenCount.get()!=0||releasedOxygenCount.get()!=0)||hydrogenCount.get()>=2&&oxygenCount.get()>=1){
//                if(releasedOxygenCount.get()<1){
//                    // releaseOxygen.run() outputs "O". Do not change or remove this line.
//                    releaseOxygen.run();
//                    oxygenCount.decrementAndGet();
//                    releasedOxygenCount.incrementAndGet();
//                    if(releasedOxygenCount.get()==1&&releasedHydrogenCount.get()==2){
//                        releasedOxygenCount = new AtomicInteger(0);
//                        releasedHydrogenCount = new AtomicInteger(0);
//                    }
//                    lock.unlock();
//                    return;
//                }
//            }
//            oxygenCount.decrementAndGet();
//            lock.unlock();
//            oxygen(releaseOxygen);
//
//        }
//    }
}
