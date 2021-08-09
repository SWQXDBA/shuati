package MyTools.工具类;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Debugger {
    public static void debug(String message) {

        System.out.println("debug[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "]:" + message);
    }

    public static void info(String message) {

        System.out.println("info[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "]:" + message);
    }
}
