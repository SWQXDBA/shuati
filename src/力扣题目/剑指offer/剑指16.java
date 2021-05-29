package 力扣题目.剑指offer;

public class 剑指16 {
    public double myPow(double x, int n) {
        long g = n;
        if (g < 0) {
            x = 1 / x;
            g *= -1;
        }
        double ret = 1.0;
        while (g > 0) {
            if ((g & 1) == 1) {
                ret *= x;
            }
            x *= x;//每次都平方了。
            g = g >> 1;
        }
        return ret;
    }
}
