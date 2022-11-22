package 作业;

import java.util.Stack;

public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<String> stringStack = new Stack<>();
        for (String s : tokens) {
            if (!noNum(s))
                stringStack.push(s);
            else {
                int num2 = Integer.parseInt(stringStack.pop());
                int num1 = Integer.parseInt(stringStack.pop());
                stringStack.push(String.valueOf(suan(num1, num2, s)));
            }
        }
        return Integer.parseInt(stringStack.pop());
    }

    boolean noNum(String s) {
        if (s.equals("+") || s.equals(("-")) || s.equals(("*")) || s.equals("/"))
            return true;
        return false;
    }

    int suan(int num1, int num2, String s) {
        if (s.equals("+"))
            return num1 + num2;
        if (s.equals("-"))
            return num1 - num2;
        if (s.equals("*"))
            return num1 * num2;
        else
            return num1 / num2;
    }
}
