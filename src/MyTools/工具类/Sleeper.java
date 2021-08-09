package MyTools.工具类;

public class Sleeper {
   public static void sleep(long mills) {
       try {
           Thread.sleep(mills);
       } catch (InterruptedException e) {

       }


   }
}
