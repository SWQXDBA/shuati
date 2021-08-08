package MyTools.多线程.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyAtomicInteger {
    private static Unsafe unsafe = null;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private int value = 0;

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        MyAtomicInteger.test();
    }

    public static void test() {
        MyAtomicInteger integer = new MyAtomicInteger(1000000);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    integer.increment(-1);
                }

            });
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integer.value);
    }

    public void increment(int amount) {
        while (true) {
            int prev = value;
            int res = prev + amount;
            try {
                if (unsafe.compareAndSwapInt(this, unsafe.objectFieldOffset(this.getClass().getDeclaredField("value")), prev, res)) {
                    break;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
