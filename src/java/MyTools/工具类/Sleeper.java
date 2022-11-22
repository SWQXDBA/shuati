package MyTools.工具类;

import java.util.Random;

public class Sleeper {
    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {

        }
    }

    public static void sleepRandom(long length) {
        try {
            Random r = new Random();
            Thread.sleep(Math.abs(r.nextInt() % length));
        } catch (InterruptedException e) {

        }
    }
}
