import java.io.Closeable;

public class Main2 {
    public static void main(String[] args) {

        try (ClostTest clostTest = new ClostTest();) {

        } finally {

        }
    }

    static class ClostTest implements Closeable {
        public ClostTest() {
        }

        public void close() {
            System.out.println("关闭了");
        }
    }
}
