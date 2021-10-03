import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int canUseMoney, m;
            canUseMoney = scanner.nextInt();
            m = scanner.nextInt();
            List<Cow> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int money, count;
                money = scanner.nextInt();
                count = scanner.nextInt();
                Cow cow = new Cow();
                cow.price = money;
                cow.count = count;
                list.add(cow);
            }
            list.sort(Cow::compareTo);
            Cow[] cows = list.toArray(new Cow[0]);

            int left = 0;
            int right = 0;
            int pri;
            int[] bag = new int[list.size()];
            int[] count = new int[list.size()];
            while (true) {
                for (int i = 0; i < cows.length; i++) {
                    if (cows[i].count <)
                }


                if (canBuy(cows, left, right, canUseMoney)) {
                    right++;
                } else {
                    if (!canBuy(cows, right, right, canUseMoney)) {//单独的那个都不能自己买
                        right--;//退回前一次
                    } else {
                        int rightcnt = getCount(cows, right, right);
                        if (rightcnt > getCount(cows, left, right - 1)) {//一支独大 就只买他的
                            left = right;
                        } else {
                            right--;//退回前一个
                        }
                    }
                    break;
                }
            }
            System.out.println(getCount(cows, left, right));

        }
    }

    public static int price(Cow[] array, int left, int right) {
        int c = 0;
        for (int i = left; i <= right; i++) {
            c += array[i].price;
        }
        return c;
    }

/*
70 3
70 100
69 1
1 2


70 4
70 30
70 52
69 1
1 50


70 4
36 3
35 100
34 20
2 10
    */

    public static int getCount(Cow[] array, int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            cnt += array[i].count;
        }
        return cnt;
    }

    public static Boolean canBuy(Cow[] array, int left, int right, int money) {
        return price(array, left, right) <= money;
    }

    static class Cow implements Comparable<Cow> {
        int price;
        int count;

        @Override
        public int compareTo(Cow o) {
            if (price == o.price) {
                return o.count - count;
            }
            return price - o.price;
        }

        @Override
        public String toString() {
            return price + ":" + count + " ";
        }
    }
}

//BBABCAAABD