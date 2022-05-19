import MyTools.工具类.Sleeper;
import MyTools.工具类.StopWatch;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SWQXDBA
 */
public class Main {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        //  Collection<String> list = ConcurrentHashMap.newKeySet();
        Collection<String> list = ConcurrentHashMap.newKeySet(100000);
        //    Collection<String> list = new Vector<>();
        //   Collection<String> list = new LinkedBlockingQueue<>();

        // Collection<String> list = new ConcurrentLinkedQueue<>();


        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    list.add(finalI + "a" + j);
                }
                System.out.println(stopWatch.getPassedMills());
                System.out.println(list.size());
            });
            thread.start();
        }


        Sleeper.sleep(99999999);
    }

}

