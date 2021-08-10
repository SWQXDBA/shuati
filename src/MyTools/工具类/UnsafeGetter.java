package MyTools.工具类;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeGetter {
    public static Unsafe get() {
        Unsafe unsafe = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(Unsafe.class);//因为field是一个静态成员 因此可以也可以传入null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
        return unsafe;
    }

    public static void main(String[] args) {
        Unsafe unsafe = get();
        T i = new T();
        try {
            Field field = i.getClass().getDeclaredField("value");
            long offset = unsafe.objectFieldOffset(field);
            unsafe.compareAndSwapInt(i, offset, 0, 15);
            System.out.println(i.value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    static class T {
        int value = 0;
    }
}
