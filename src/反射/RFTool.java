package 反射;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class RFTool {
    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(1000);
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(null, () -> {
                int tryCount = 1;
                while (true) {
                    boolean ok = true;
                    for (int j = 0; j < 1000; j++) {
                        if (array.compareAndSet(j, 0, 1)) {
                            System.out.println(Thread.currentThread().getName() + " 设置了" + j + " 次数:" + tryCount);
                        } else {
                            System.out.println(Thread.currentThread().getName() + " 设置" + j + "失败!");
                        }
                    }
                    tryCount++;
                    for (int j = 0; j < 1000; j++) {
                        if (array.get(j) != 1) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        break;
                    }
                }
            }, "线程" + i);
            thread.start();

        }
    }

    public static <T> Method getMethodByName(Class<T> c, String name) {

        try {
            return c.getMethod(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class tryd {
        public void func(String s) {
            System.out.println(s);
        }
    }
}
