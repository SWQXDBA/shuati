package MyReactor;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        One<String> just = One.just("123");
        One<Integer> map = just.map(Integer::valueOf).map((i) -> i * 3);
        System.out.println(map.submit());
        System.out.println(map.get());
        Stream.of(1);
    }
}
