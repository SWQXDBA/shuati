import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        char[] chars = new char[1024 * 1024 * 1024];
        Arrays.fill(chars, 'a');
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}

