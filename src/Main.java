public class Main {
 public static void main(String[] args) {

  ClassLoader ts = Main.class.getClassLoader();
  System.out.println(ts);
  ClassLoader classLoader = ClassLoader.getSystemClassLoader();
  System.out.println(classLoader);
  String
 }

 static class father {
  static int num = 1;

  static {
   num = 20;
  }

  public int num2 = 2;
 }

 static class father2 {
  static int num = 1;

  static {
   num = 20;
  }

  public int num2 = 2;
 }

 static class son extends father {
  static int num = father.num;

  public son(int n) {
   super();
   this.num2 = 1;

  }
 }
}
