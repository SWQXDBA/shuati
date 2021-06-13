package 力扣题目.剑指offer;

import java.util.Stack;

public class 剑指31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poploc = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[poploc]) {
                stack.pop();
                poploc++;
            }
        }
        return stack.isEmpty();
    }
}
