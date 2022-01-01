package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class 计算字符串的距离 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(minDistance(str1, str2));
        }
    }
/*    如果两个字符串的最后一个字符一样，那么，我们就可以递归地计算长度为m-1和n-1的两个字符串的情形；

    如果两个字符串的最后一个字符不一样，那么，进入以下三种情形：

    插入： 递归地计算长度为m和n-1的两个字符串的情形，这是因为在s1中的末端插入了一个s2的最后一个字符，这样s1和s2的末端字符一样，就是1中情形；

    删除： 递归地计算长度为m-1和n的两个字符串的情形，这是在s1中的末端删除了一个字符；

    替换： 递归地计算长度为m-1和n-1的两个字符串的情形，这是因为把s1中末端字符替换成了s2的最后一个字符，这样s1和s2的末端字符一样，就是1中情形；
    */

    //自己写的超时
    public static int len(char[] chars1, char[] chars2, int i1, int i2) {
        if (i1 < 0 && i2 < 0) {
            return 0;
        }
        if (i1 < 0) {
            return i2 + 1;
        }
        if (i2 < 0) {
            return i1 + 1;
        }
        if (chars1[i1] == chars2[i2]) {
            return len(chars1, chars2, i1 - 1, i2 - 1);
        }
        int a = 1 + len(chars1, chars2, i1, i2 - 1);//i1减掉一个
        int b = 1 + len(chars1, chars2, i1 - 1, i2);//i2减掉一个
        int c = 1 + len(chars1, chars2, i1 - 1, i2 - 1);//替换
        a = Math.min(a, b);
        c = Math.min(c, a);
        return c;
    }

    //搜的
    public static int minDistance(String word1, String word2) {
        int[][] strLen = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) strLen[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) strLen[0][j] = j;

        System.out.println(Arrays.deepToString(strLen));
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) strLen[i][j] = strLen[i - 1][j - 1];
                else {
                    strLen[i][j] = Math.min(strLen[i - 1][j], strLen[i][j - 1]);
                    strLen[i][j] = Math.min(strLen[i][j], strLen[i - 1][j - 1]) + 1;
                }
            }
        }

        return strLen[word1.length()][word2.length()];
    }
}
