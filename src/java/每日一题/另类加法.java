package 每日一题;

public class 另类加法 {

    public static void main(String[] args) {


    }

    /*
思路：肯定是用位运算，我记得位运算A^B是不考虑进位的结果，（A&B）<<1是求得的进位
因此A^B+（A&B）<<1的结果就是和，只要（A&B）<<1=0，两项就变成了一项，不需要加法了

*/
    public int addAB(int A, int B) {
        while (B != 0) {
            int a = A ^ B;
            int b = (A & B) << 1;
            A = a;
            B = b;
        }
        return A;
    }
}

