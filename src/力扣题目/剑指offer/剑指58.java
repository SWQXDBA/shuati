package 力扣题目.剑指offer;

public class 剑指58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
