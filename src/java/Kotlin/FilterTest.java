package Kotlin;

import java.util.Arrays;

public class FilterTest {
    public static void test() {
        Obj[] array = {new Obj("1"), new Obj("2")};
        Arrays.stream(array).filter(i -> {
            System.out.println(" filter " + i);
            return true;
        }).map(i -> {
            System.out.println("map:" + i);
            return ("" + i);
        }).forEach(System.out::println);
    }

    static class Obj {
        String name;

        public Obj(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
