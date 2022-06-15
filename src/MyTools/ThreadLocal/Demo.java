package MyTools.ThreadLocal;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        LocalWrapper<String> wrapper = new LocalWrapper<>();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {

                System.out.println(wrapper.get());
                wrapper.set(finalI + "");
                System.out.println(wrapper.get());
            });
            thread.start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class LocalWrapper<T> {
        ThreadLocal<T> local = new ThreadLocal<>();

        public void set(T t) {
            local.set(t);
        }

        public T get() {
            return local.get();
        }
    }
}
