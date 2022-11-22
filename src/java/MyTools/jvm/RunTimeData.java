package MyTools.jvm;

public class RunTimeData {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory() / 1000000);
        System.out.println(Runtime.getRuntime().maxMemory() / 1000000);

        System.out.println(Runtime.getRuntime().totalMemory() / 1000000);

    }
}
