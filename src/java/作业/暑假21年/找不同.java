package 作业.暑假21年;

public class 找不同 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        if (t.length() == 0) {
            return s.charAt(0);
        }
        int c = 0;
        for (char ch : s.toCharArray()) {
            c ^= ch;
        }
        for (char ch : t.toCharArray()) {
            c ^= ch;
        }
        return (char) c;

    }
}
