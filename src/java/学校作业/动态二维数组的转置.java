package 学校作业;

import java.util.Scanner;

public class 动态二维数组的转置 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Box box = new Box();
            box.hang = scanner.nextInt();
            box.lie = scanner.nextInt();
            for (int i = 0; i < box.hang; i++) {
                for (int j = 0; j < box.lie; j++) {
                    box.ints[i][j] = scanner.nextInt();
                }
            }
            box.show1();
            box.show2();
        }
    }

    static class Box {
        public int hang;
        public int lie;
        public int[][] ints = new int[100][100];

        public void show1() {
            for (int i = 0; i < hang; i++) {
                for (int j = 0; j < lie; j++) {
                    System.out.printf("%5d", ints[i][j]);
                }
                System.out.println();
            }
        }

        public void show2() {
            for (int i = 0; i < lie; i++) {
                for (int j = 0; j < hang; j++) {
                    System.out.printf("%5d", ints[j][i]);
                }
                System.out.println();
            }
        }

    }
}
