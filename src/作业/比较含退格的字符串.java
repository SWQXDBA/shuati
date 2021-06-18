package 作业;

import java.util.Stack;

public class 比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            }
            if (c == '#' && !stack1.isEmpty()) {
                stack1.pop();
            }
        }
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
            }
            if (c == '#' && !stack2.isEmpty()) {
                stack2.pop();
            }
        }
        if (stack1.size() != stack2.size())
            return false;
        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop())
                return false;
        }
        return true;
    }//、、、
}
