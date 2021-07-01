package 力扣题目.剑指offer;

import java.util.Stack;

public class 剑指30 {
    class MinStack {
        //用辅助栈维护当前元素中最小的那个
        Stack<Integer> mainStack, helperStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            mainStack = new Stack<>();
            helperStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
            if (helperStack.isEmpty() || x <= helperStack.peek())
                helperStack.push(x);
        }

        public void pop() {
            int num = mainStack.pop();
            if (num == helperStack.peek()) {
                helperStack.pop();
            }
        }

        public int top() {
            return mainStack.peek();
        }

        public int min() {
            return helperStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
