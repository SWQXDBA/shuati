package MyTools.工具类;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {

    public static <T> T[] generate(Parser<T> parser, int size, Class<? extends T[]> newType) {

        Random random = new Random();
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = parser.parse(random.nextInt());
        }

        return Arrays.copyOf(array, array.length, newType);
    }

    @FunctionalInterface
    public interface Parser<T> {
        T parse(int i);
    }
}
