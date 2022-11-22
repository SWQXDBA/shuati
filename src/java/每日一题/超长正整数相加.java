package 每日一题;

import java.util.Scanner;
import java.util.Stack;

public class 超长正整数相加 {
    ///别人的代码
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()) {
//            String a = sc.nextLine();
//            String b = sc.nextLine();
//
//            // 求出两个字符串中较长的那个字符串长度
//            int lenA = a.length();
//            int lenB = b.length();
//            int lenS = Math.max(lenA, lenB);
//
//            // S保存最终生成的结果
//            int[] A = new int[lenS];
//            int[] B = new int[lenS];
//            int[] S = new int[lenS + 1];
//
//            for (int i = 0; i < lenA; i++) {
//                A[i] = a.charAt(lenA - 1 - i) - '0';
//            }
//
//            for (int i = 0; i < lenB; i++) {
//                B[i] = b.charAt(lenB - 1 - i) - '0';
//            }
//
//            for (int i = 0; i < lenS; i++) {
//                int sum = S[i] + A[i] + B[i];
//                int flag = sum /10;
//                S[i]  = sum % 10;
//                S[i+1] += flag;
//            }
//
//            for (int i = (S[lenS] == 0?1:0); i < lenS + 1; i++) {
//                System.out.print(S[lenS - i]);
//            }
//
//            System.out.println();
//
//        }
//
//        sc.close();
//
//————————————————
//        版权声明：本文为CSDN博主「糯米团子沐沐」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/qq_43765564/article/details/103166209
//
    //我的代码 使用栈
    public static String AddLongInteger(String A, String B) {
        //先把String转成char数组，然后遍历进行入栈
        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : str1) {
            stack1.push(c);
        }
        for (char c : str2) {
            stack2.push(c);
        }
        //ten用来存进位
        int ten = 0;
        //储存结果的栈
        Stack<Integer> ret = new Stack<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int left = stack1.pop() - '0';
            int right = stack2.pop() - '0';
            int sum = left + right;
            //处理上一次的进位
            sum += ten;
            if (sum >= 10) {
                ten = sum / 10;
                sum %= 10;
            } else {
                //别忘了把进位初始化
                ten = 0;
            }
            ret.push(sum);
        }
        //此时可能有一个栈不是空的 或者都是空的

        if (!stack1.isEmpty() || !stack2.isEmpty()) {
            //获得不是空的那个
            Stack<Character> last = stack1.isEmpty() ? stack2 : stack1;
            while (!last.isEmpty()) {
                //与上面同理 记得把进位加上
                int sum = last.pop() - '0';
                sum += ten;
                if (sum >= 0) {
                    ten = sum / 10;
                    sum %= 10;
                } else {
                    ten = 0;
                }
                ret.push(sum);
            }
            //最后一个元素处理完后 可能还存在进位
            if (ten != 0)
                ret.push(ten);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!ret.isEmpty()) {
            //取出栈顶元素（高位）
            stringBuilder.append(ret.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(AddLongInteger(s1, s2));
        }
    }
}
