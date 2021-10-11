package 每日一题;

import java.util.Scanner;
import java.util.Stack;

public class 倒置字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            Stack<String> stack = new Stack<>();
            for (String s : str.split(" ")) {
                stack.push(s);
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
                if (!stack.isEmpty()) {
                    System.out.print(" ");
                }
            }
        }
    }
}
