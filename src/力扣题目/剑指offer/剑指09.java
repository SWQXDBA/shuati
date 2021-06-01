package 力扣题目.剑指offer;

import java.util.Stack;

public class 剑指09 {
    static class CQueue {
        Stack<Integer> vales = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            vales.push(value);
        }

        public int deleteHead() {
            if (vales.empty())
                return -1;
            Stack<Integer> temp = new Stack<>();
            while (!vales.empty()) {
                temp.push(vales.pop());
            }
            int ret = temp.pop();
            while (!temp.empty()) {
                vales.push(temp.pop());
            }
            return ret;

        }
    }
}
