package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 杨辉三角的变形 {
    static int getNum(List<Integer> list, int index) {
        int sum = 0;
        for (int i = index - 2; i <= index; i++) {
            if (i < 0 || i >= list.size())
                continue;
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
                List<Integer> hang = list.get(i);
                if (i == 0) {
                    hang.add(1);
                } else {
                    for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                        hang.add(getNum(list.get(i - 1), j));
                    }
                }
            }


//                    for (List<Integer> ls:list){
//                        for(Integer i:ls){
//                            System.out.printf("%d ",i);
//                        }
//                        System.out.println();
//                    }
            List<Integer> target = list.get(n - 1);
            for (Integer i : target) {
                if (i % 2 == 0) {
                    System.out.println(target.indexOf(i) + 1);
                    break;
                }
            }
        }
    }
}
