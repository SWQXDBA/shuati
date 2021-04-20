import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int two = 0;
        int five = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                temp /= 2;
                two++;
            }
            temp = i;
            while (temp % 5 == 0) {
                temp /= 5;
                five++;
            }

            //这里不能把每个数都拿来算，而是统计所有数中2和5的总数再进行计算
//            while(temp%2==0){
//                temp/=2;
//                two++;
//            }
//            temp = i;
//            while(temp%5==0){
//                temp/=5;
//                five++;
//            }
//            cnt+=Math.min(two,five);
        }
        System.out.println(Math.min(two, five));
    }

}
