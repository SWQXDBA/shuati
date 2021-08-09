package MyTools.工具类;

public class Sleeper {
    static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {

        }


    }
}
