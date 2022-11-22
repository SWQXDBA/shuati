package MyTools.多线程.JUC使用.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//自定义锁 不可重入
public class MyLock implements Lock {
    private MySync sync = new MySync();

    @Override
    public void lock() {
        sync.acquire(1);//内部会反复尝试调用tryAcquire加锁
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {

        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        //会尝试唤醒等待中的线程
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    class MySync extends AbstractQueuedSynchronizer {

        //AQS中由state变量代表是否加了锁 0代表未加锁 1代表已经加锁
        @Override//尝试加锁
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override//尝试释放锁
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);//放在volatile的state前面
            //state为volatile 在他之前的代码修改对其他县城可见(写屏障)
            setState(0);

            return true;
        }

        @Override//是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }
}
