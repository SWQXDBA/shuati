package 力扣题目.剑指offer;

public class 剑指17 {
    public int[] printNumbers(int n) {

        int max = (int) Math.pow(10, n) - 1;
        int[] ret = new int[max];
        for (int i = 0; i < max; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
