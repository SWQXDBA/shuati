package 每日一题;

import java.util.Scanner;

public class 星际密码 {
    //    自己的写法
    public static int[][] multiply(int[][] A, int[][] B) {
        if (A[0].length != B.length) {

            return null;
        } else {
            int[][] C = new int[A.length][B[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int t = 0; t < A[0].length; t++) {

                        C[i][j] += A[i][t] * B[t][j];
                    }
                }
            }

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    if (C[i][j] > 10000) {
                        C[i][j] %= 10000;
                    }
                }

            }
            return C;
        }
    }

    public static String getKey(int n) {
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = base;
        for (int i = 0; i < n - 1; i++) {
            res = multiply(res, base);
        }
        long i = res[0][0];
        i %= 10000;
        return String.format("%04d", i);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(getKey(scanner.nextInt()));
            }
            System.out.println(stringBuilder.toString());
        }
    }

//    题解:通过观察知道其实是斐波那契数列

 /*   public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] fib=new int[10001];
        fib[1]=1;
        fib[2]=2;
        //计算斐波那契数列
        for (int i=3;i<=10000;i++){
            fib[i]=(fib[i-1]+fib[i-2])%10000;
        }
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] num=new int[n];
            for (int i=0;i<n;i++){
                num[i]=scanner.nextInt();
            }

            for (int i=0;i<n;i++){
                s2(fib[num[i]]);
            }
            //完成一组测试数据计算后换行
            System.out.println();
        }
    }

    private static void s2(int num){
        String str="";
        //将数字转换为字符串
        str+=num;
        //求出当前字符串的长度，该长度就是数字的位数
        int le=str.length();
        //长度为4时直接打印
        if (le==4){
            System.out.print(str);
        }else if (le>4){
            //长度大于4时截取后四位并打印
            System.out.print(str.substring(le-4));
        }else if (le<4){
            //长度小于四位则先打印0补足缺少的位数，再打印字符串
            for (int i=0;i<4-le;i++){
                System.out.print('0');
            }
            System.out.print(str);
        }
    }*/
}
