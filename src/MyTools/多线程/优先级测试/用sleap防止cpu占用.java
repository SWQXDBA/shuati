package MyTools.多线程.优先级测试;

public class 用sleap防止cpu占用 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        // Thread.sleep(50);

                    }
                }
            }).start();
        }
    }
}
