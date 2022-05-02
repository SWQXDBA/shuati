package MyTools.工具类;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Debugger {
    public static void debug(Object o) {
        System.out.println("debug:" + Thread.currentThread().getName() + " [" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "]:" + o.toString());
    }

    public static void info(Object o) {
        System.out.println("info:" + Thread.currentThread().getName() + " [" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "]:" + o.toString());
    }
}
