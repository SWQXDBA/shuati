package 作业;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fibonacci数列 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            for (String s : str.split(" ")) {
                set.add(s);
            }

        }
        System.out.println(set.size());
    }
}

