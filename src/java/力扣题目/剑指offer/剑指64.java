package 力扣题目.剑指offer;

public class 剑指64 {
  static int res=0;
    public int sumNums(int n) {
        res=0;
        getSum(n);
       return res;
    }
    static boolean getSum(int n){
       boolean x=(n>1)&&getSum(n-1);
       res+=n;
       return true;
    }

}
