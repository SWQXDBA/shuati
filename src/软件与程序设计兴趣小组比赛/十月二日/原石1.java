package 软件与程序设计兴趣小组比赛.十月二日;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 原石1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n, m;
            n = scanner.nextInt();
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
            int get = 0;
            int userMoney = 0;
            for (int i = 0; i < list.size(); i++) {
                Cow cow = list.get(i);
                if (get + cow.count >= n) {
                    int needToBuy = n - get;
                    userMoney += needToBuy * cow.price;
                    break;
                }
                get += cow.count;
                userMoney += cow.price * cow.count;
            }
            System.out.println(userMoney);
        }
    }

    static class Cow implements Comparable<Cow> {
        int price;
        int count;

        @Override
        public int compareTo(Cow o) {
            return price - o.price;
        }

        @Override
        public String toString() {
            return price + ":" + count + " ";
        }
    }
}
