import MyTools.工具类.StopWatch;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SWQXDBA
 */

public class Main {
    static volatile long cnt = 0;

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();

        List<Thread> threads = new ArrayList<>();
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {

            final VarHandle handle = lookup.findStaticVarHandle(Main.class, "cnt", long.class);
            for (int i = 0; i < 100; i++) {
                Thread thread = new Thread(() -> {
                    for (int j = 0; j < 1000000; j++) {
                        long cnt1 = Main.cnt;
                        int tryCount = 0;

//                        while(tryCount<1&&!handle.compareAndSet(cnt1,cnt1+1)){
//                            tryCount++;
//                            cnt1 = Main.cnt;
//                        }
//
//                        if(tryCount==1){
//                            synchronized (Main.class){
//                                while(!handle.compareAndSet(cnt1,cnt1+1)){
//                                    cnt1 = Main.cnt;
//                                }
//                            }
//                        }
//                        while(!handle.compareAndSet(cnt1,cnt1+1)){
//                            tryCount++;
//                            cnt1 = Main.cnt;
//                        }

                        synchronized (Main.class) {
                            Main.cnt = Main.cnt + 1;
                        }
                    }
                });
                threads.add(thread);
                thread.start();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(cnt);

        System.out.println(stopWatch.getPassedMills());
    }

}

