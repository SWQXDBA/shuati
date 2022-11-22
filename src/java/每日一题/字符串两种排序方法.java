package 每日一题;

import java.util.Scanner;

public class 字符串两种排序方法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.nextLine();
            }
            boolean isDicSortOk = true;
            boolean isLengthSortOk = true;
            for (int i = 1; i < n; i++) {
                if (!dicSort(strs[i - 1], strs[i])) {
                    isDicSortOk = false;
                }
                if (!lengthSort(strs[i - 1], strs[i])) {
                    isLengthSortOk = false;
                }
            }
            if (isDicSortOk && isLengthSortOk) {
                System.out.println("both");
            } else if (isDicSortOk) {
                System.out.println("lexicographically");
            } else if (isLengthSortOk) {
                System.out.println("lengths");
            } else {
                System.out.println("none");
            }

        }
    }

    public static boolean dicSort(String str1, String str2) {
        return str1.compareTo(str2) <= 0;
    }

    public static boolean lengthSort(String str1, String str2) {
        return str1.length() <= str2.length();
    }
}
