import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            long[] numbers = new long[Math.toIntExact(n)];
            long max = 10000000;
            boolean[] array = new boolean[Math.toIntExact(max + 1)];//用于欧拉筛 true为非素数
            init(array);

            for (long i = 0; i < n; i++) {
                long number = scanner.nextLong();
                if (number == 0) {
                    System.out.println(1);
                    System.out.println("0 = 0");
                    continue;
                }
                Stack<Long> res = new Stack<>();
                getRes(res, number, array);
                System.out.println(res.size());
                while (!res.isEmpty()) {
                    System.out.print(res.pop());
                    if (!res.isEmpty()) {
                        System.out.print(" + ");
                    }
                }
                System.out.println(" = " + number);
            }

        }
    }

    public static void getRes(Stack<Long> res, long num, boolean[] array) {
        long temp = num;
        while (temp >= 0 && array[Math.toIntExact(temp)]) {
            temp--;
        }
        //此时temp为最大的素数了
        res.push(temp);
        long need = num - temp;
        if (need == 0) {
            return;
        }

        getRes(res, need, array);
    }

    public static void init(boolean[] array) {
        long start = 2;
        while (start < array.length) {
            if (!array[Math.toIntExact(start)]) {
                long t = 2;
                while (start * t < array.length) {
                    array[Math.toIntExact(start * t)] = true;
                    t++;
                }
            }

            start++;

        }

    }

}
