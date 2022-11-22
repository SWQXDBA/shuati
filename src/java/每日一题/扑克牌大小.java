package 每日一题;

import java.util.Scanner;

public class 扑克牌大小 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String pai = scanner.nextLine();
            String[] left = pai.split("-")[0].split(" ");
            String[] right = pai.split("-")[1].split(" ");
            PAI[] leftpais = new PAI[left.length];
            for (int i = 0; i < leftpais.length; i++) {
                leftpais[i] = new PAI(left[i]);
            }
            PAI[] rightpais = new PAI[right.length];
            for (int i = 0; i < rightpais.length; i++) {
                rightpais[i] = new PAI(right[i]);
            }
            int win = -1;
            ///炸弹
            if (isBoom(leftpais)) {
                if (!isBoom(rightpais))
                    win = 0;
            }

            if (isBoom(rightpais)) {
                if (!isBoom(leftpais))
                    win = 1;
            }

            if (isBoom(leftpais) && isBoom(rightpais)) {
                if (leftpais[0].loc < rightpais[0].loc)
                    win = 1;
                else
                    win = 0;

            }
            ///三个
            if (isThree(leftpais) && isThree(rightpais)) {
                if (leftpais[0].loc < rightpais[0].loc)
                    win = 1;
                else
                    win = 0;
            }

            //两个
            if (isTwo(leftpais) && isTwo(rightpais)) {
                if (leftpais[0].loc < rightpais[0].loc)
                    win = 1;
                else
                    win = 0;
            }
//顺子
            if (isShunZi(leftpais) && isShunZi(rightpais)) {
                if (leftpais[0].loc < rightpais[0].loc)
                    win = 1;
                else
                    win = 0;
            }

            if (leftpais.length == 1 && rightpais.length == 1) {
                if (leftpais[0].loc < rightpais[0].loc)
                    win = 1;
                else
                    win = 0;
            }
            if (win == 0) {
                for (PAI p : leftpais) {
                    System.out.print(p.name + " ");
                }
            } else if (win == 1) {
                for (PAI p : rightpais) {
                    System.out.print(p.name + " ");
                }
            } else {
                System.out.println("ERROR");
            }

        }

    }

    static boolean isBoom(PAI[] s) {
        if (s.length == 2) {
            for (PAI x : s) {
                if (x.loc != 13 && x.loc != 14)
                    return false;
            }
            return true;
        }
        if (s.length == 4) {
            int N = s[0].loc;
            for (PAI x : s) {
                if (x.loc != N)
                    return false;
            }
            return true;
        }
        return false;
    }

    static boolean isThree(PAI[] s) {
        if (s.length != 3)
            return false;
        int N = s[0].loc;
        for (PAI x : s) {
            if (x.loc != N)
                return false;
        }
        return true;
    }

    static boolean isTwo(PAI[] s) {
        if (s.length != 2)
            return false;
        int N = s[0].loc;
        for (PAI x : s) {
            if (x.loc != N)
                return false;
        }
        return true;
    }

    static boolean isShunZi(PAI[] s) {
        if (s.length != 5)
            return false;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i + 1].loc - s[i].loc != 1)
                return false;
        }
        return true;
    }

    static class PAI {
        static String[] pais = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
        public int loc = -1;
        public String name;

        public PAI(String n) {
            for (int i = 0; i < pais.length; i++) {
                if (pais[i].equals(n))
                    loc = i;
            }
            this.name = n;
        }

    }
}
