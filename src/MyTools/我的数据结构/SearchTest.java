package MyTools.我的数据结构;

import java.util.Random;

public class SearchTest {
    public static void main(String[] args) {
        Person[] array = new Person[10000000];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = new Person();
            array[i].id = r.nextInt(100000);
            array[i].name = String.valueOf(r.nextInt(100000));
        }
        Long start = System.currentTimeMillis();
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].id % 13 == 0) {
                if (array[i].name.contains("12321")) ;
                x++;
            }
        }
        System.out.println(x);
        System.out.println("over" + (System.currentTimeMillis() - start) + "mills");
    }

    static class Person {


        int id;
        String name;
    }
}
