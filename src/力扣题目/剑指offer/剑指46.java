package 力扣题目.剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 剑指46 {
    static public int translateNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(0, num % 10);
            num /= 10;
        }
        int ret = dfs(list, list.size() - 1);
        return ret;
    }

    static int dfs(List<Integer> list, int index) {
        if (index == 0)
            return 1;
        if (index == -1)
            return 1;
        int num = list.get(index - 1) * 10 + list.get(index);
        if (num <= 25 && list.get(index - 1) != 0) {
            return dfs(list, index - 1) + dfs(list, index - 2);
        }
        return dfs(list, index - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            System.out.println(translateNum(a));
        }
    }
}
