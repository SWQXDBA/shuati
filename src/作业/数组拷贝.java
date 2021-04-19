package 作业;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 数组拷贝 {

    public static <T> T[] copyof(T[] arr) {
        T[] newarr = (T[]) Array.newInstance(arr[0].getClass(), arr.length);
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        person[] people = new person[5];
        for (int i = 0; i < 5; i++) {
            people[i] = new person();
        }
        for (int i = 0; i < 5; i++) {
            people[i].setAge(scanner.nextInt());
            people[i].setName(scanner.next());
        }
        System.out.println(Arrays.toString(copyof(people)));

    }

    static class person {
        int age;
        String name;

        @Override
        public String toString() {
            return "person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
