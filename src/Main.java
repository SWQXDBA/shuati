import java.util.Arrays;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        String[] arr = {"1,1", "2,2"};
        Stream<String> stream = Arrays.stream(arr);
        // stream.forEach(System.out::println);流只能用一次
        Stream<String> stringStream = stream.flatMap(s -> Stream.of(s.split(",")));

        stringStream.forEach(System.out::println);

    }


}

