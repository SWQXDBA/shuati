import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    static <T extends Comparator<T>, B extends Comparator<B>> void sort(T[] arr, B[] arr2) {

    }

    static void sortObject(Object[] arr) {
        Comparator comparator = (Comparator) arr[0];
    }

    public static void main(String[] args) {
        Object o = new Object() {
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("aaa"));
        Arrays.sort(new Object[5]);
    }
}
