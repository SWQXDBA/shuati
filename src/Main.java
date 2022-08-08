import java.util.List;


/**
 * @author SWQXDBA
 */

public class Main {
    public static void main(String[] args) {

        List.of(1, 2, 3).parallelStream().forEach(integer -> System.out.println(Thread.currentThread()));
    }

}

