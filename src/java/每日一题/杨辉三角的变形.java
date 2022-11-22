package 每日一题;

import java.util.Scanner;

public class 杨辉三角的变形 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //找规律
            if (n <= 2) //前两层没有偶数
                System.out.println(-1);
            else if ((n & 1) != 0) //除第一层之外的奇数层：偶数在第2个位置
                System.out.println(2);
            else if (n % 4 == 0) //4的倍数层：偶数在第3个位置
                System.out.println(3);
            else //其它层(除第二层外的非4的倍数的偶数层)：偶数在第4个位置
                System.out.println(4);
        }
    }
    //暴力会oom
  /*  static int getNum(List<Integer> list, int index) {
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
            boolean find = false;
            for (Integer i : target) {
                if (i % 2 == 0) {
                    find = true;
                    System.out.println(target.indexOf(i) + 1);
                    break;
                }
            }
            if(!find){
                System.out.println(-1);
            }
        }
    }*/
}
