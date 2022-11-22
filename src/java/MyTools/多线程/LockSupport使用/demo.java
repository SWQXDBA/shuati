package MyTools.多线程.LockSupport使用;

import MyTools.工具类.Debugger;
import MyTools.工具类.Sleeper;

import java.util.concurrent.locks.LockSupport;

public class demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Debugger.debug("锁上了");
            LockSupport.park();
            Debugger.debug("解锁了");
        });
        t1.start();
        Sleeper.sleep(1000);
        Thread t2 = new Thread(() -> {
            LockSupport.unpark(t1);
            Debugger.debug("解锁了t1");
        });
        t2.start();
    }
}
