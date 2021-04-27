package 每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 幸运的袋子 {
    //通过率20 超时了
    private static Set<ArrayList<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int pack = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < pack; i++) {
                list.add(scanner.nextInt());
            }
            System.out.println(luckyHelper(list));

        }
    }

    public static int luckyHelper(ArrayList<Integer> list) {

        if (list.isEmpty())
            return 0;
        int ret = 0;
        if (isLucky(list))
            ret++;

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> tempList = new ArrayList<>(list);

            tempList.remove(i);

            //避免重复计算
            if (set.contains(tempList))
                continue;

            ret += luckyHelper(tempList);
            set.add(tempList);

        }

        return ret;
    }

    public static boolean isLucky(ArrayList<Integer> list) {
        int sum = 0;
        int x = 1;
        for (Integer i : list) {
            sum += i;
            x *= i;
        }


        return sum > x;
    }
}
