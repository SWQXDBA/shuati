package 每日一题;

public class 合法括号序列判断 {
    public boolean chkParenthesis(String A, int n) {
        String str = A;
        int leftCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                leftCount++;
            }
            if (c == ')') {
                leftCount--;
            }
            if (leftCount < 0) {
                return false;
            } else {
                continue;
            }
        }
        return leftCount == 0;
    }

}
