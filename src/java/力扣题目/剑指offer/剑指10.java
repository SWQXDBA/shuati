package 力扣题目.剑指offer;

public class 剑指10 {
    static public int fib(int n) {
        int pre1 = 0;
        int pre2 = 1;

        for (int i = 0; i < n; i++) {
            int sum = (pre1 + pre2) % 1000000007;
            pre1 = pre2;
            pre2 = sum;
        }

        return pre1;
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
    }
}
