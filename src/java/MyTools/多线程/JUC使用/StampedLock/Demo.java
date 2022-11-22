package MyTools.多线程.JUC使用.StampedLock;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.locks.StampedLock;

//StampedLock不支持可重入和条件唤醒
@SuppressWarnings("ALL")
public class Demo {
    public static void main(String[] args) {
        Point point = new Point();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(point.getLocation());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                point.set(i, i + 1);
                System.out.println("设置了" + i + " " + (i + 1));
                Sleeper.sleep(1500);
            }
        });
        t1.start();
        t2.start();
    }

    static class Point {
        StampedLock lock = new StampedLock();
        private int x = 0;
        private int y = 0;

        private static double loc(int x, int y) {
            Sleeper.sleep(500);
            return Math.pow(x * x + y * y, 0.5);
        }

        //获取点到原点的坐标
        public double getLocation() {

            ////////////////////////////////////////
            //以下为尝试读取的代码块 为了保证不会因为不可重复读获取到脏的数据(此时可以被写入) 需要验证数据一致性
            long stamp = lock.tryOptimisticRead();
            Debugger.debug("尝试乐观读");
            double ret = loc(x, y);
            /////////////////////////////////////////
            //if判断在读取数据的过程中 是否有其他线程写入 如果没有 则可以保证读取数据的一致性
            //会调用  U.loadFence();启用读屏障 保证读取的stamp是最新值
            if (lock.validate(stamp)) {///注意 在此代码块中 可能有其他的线程会写入数据 但是不会影响被保存的上一次数据的一致性
                Debugger.debug("乐观读锁成功！！！！！！！");
                Sleeper.sleep(600);
                return ret;
            }
            Debugger.debug("乐观读锁失败");
            try {
                Debugger.debug("尝试获得读锁");
                //尝试强制加读锁 保证读操作的数据的一致性
                stamp = lock.readLock();
                Debugger.debug("读锁获得成功");
                ret = loc(x, y);
                return ret;
            } finally {
                lock.unlockRead(stamp);
                Debugger.debug("读锁释放");
            }

        }

        public void set(int x, int y) {
            Debugger.debug("尝试获取写锁");
            long stamp = lock.writeLock();
            Debugger.debug("获取写锁成功");
            this.x = x;
            this.y = y;
            Sleeper.sleep(100);
            Debugger.debug("写锁被释放");
            lock.unlockWrite(stamp);

        }
    }
}
