package 学校作业;

import java.util.Scanner;

public class 统计英文段落的字母频度 {
    public static void main(String[] args) {

        String str = new String();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            str = scanner.nextLine();
            char[] chars = str.toCharArray();
            int[] words = new int[300];
            for (char c : chars) {
                words[c]++;
            }
            for (int i = 'A'; i <= 'Z'; i++) {
                System.out.printf("'%c' or '%c' :%d\n", i, i + 'a' - 'A', words[i] + words[i + 'a' - 'A']);
            }
        }

    }
}
