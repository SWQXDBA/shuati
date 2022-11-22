package MyTools.工具类;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Random;

public class RandomTool {
    private static final Random random = new Random();

    public static long getRandomABS(long length) {

        return Math.abs(1 + random.nextLong() % length);
    }

    //调用类似于   Integer []integers = generateRandomArray(i -> i,10,Integer[].class);
    public static <T> T[] generateRandomArray(Parser<T> parser, int size, Class<? extends T[]> newType) {

        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = parser.parse(random.nextInt());
        }
        return Arrays.copyOf(array, array.length, newType);
    }

    //获取数组元素的class对象
    public static <T> Class<?> getType(Class<? extends T[]> arrayType) {

        return arrayType.getComponentType();
    }


    @FunctionalInterface
    public interface Parser<T> {
        T parse(int i);
    }
}
