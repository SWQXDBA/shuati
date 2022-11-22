package 作业.暑假21年;

public class 压缩字符串 {
    static String func(String str) {
        char[] chars = str.toCharArray();
        int fast = 1;
        int slow = 0;
        if (str.length() == 1) {
            return str + "1";
        }
        if (str.length() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (slow < chars.length) {
            while (fast < chars.length && chars[fast] == chars[slow]) {
                fast++;
            }
            stringBuilder.append("").append(chars[slow]).append(fast - slow);
            slow = fast;
            fast++;

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(func("aabbccdaa"));
        System.out.println(func("abbcccffr"));

    }
}
