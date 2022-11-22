package 每日一题;

import java.util.Scanner;

public class 密码强度等级 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String code = scanner.nextLine();
            int cnt = 0;
            if (code.length() <= 4) {
                cnt += 5;
            } else if (code.length() <= 7) {
                cnt += 10;
            } else {
                cnt += 25;
            }

            int shuzi = 0;
            int daxiezimu = 0;
            int xiaoxiezimu = 0;
            int fuhao = 0;
            for (char c : code.toCharArray()) {
                if (isDaXieZiMu(c)) {
                    daxiezimu++;
                }
                if (isXiaoXieZiMu(c)) {
                    xiaoxiezimu++;
                }
                if (isNumber(c)) {
                    shuzi++;
                }
                if (isSpecialCode(c)) {
                    fuhao++;
                }
            }

            //字母
            int zimu = daxiezimu + xiaoxiezimu;
            if (zimu != 0) {
                if (daxiezimu == zimu || xiaoxiezimu == zimu) {
                    cnt += 10;
                } else {
                    cnt += 20;
                }
            }

            //数字
            if (shuzi != 0) {
                if (shuzi == 1) {
                    cnt += 10;
                } else {
                    cnt += 20;
                }
            }
            //符号
            if (fuhao != 0) {
                if (fuhao == 1) {
                    cnt += 10;
                } else {
                    cnt += 25;
                }
            }

            //奖励
            if (daxiezimu != 0 && xiaoxiezimu != 0 && shuzi != 0 && fuhao != 0) {
                cnt += 5;
            } else if (zimu != 0 && shuzi != 0 && fuhao != 0) {
                cnt += 3;
            } else if (zimu != 0 && shuzi != 0) {
                cnt += 2;
            }
            if (cnt >= 90) {
                System.out.println("VERY_SECURE");
            } else if (cnt >= 80) {
                System.out.println("SECURE");
            } else if (cnt >= 70) {
                System.out.println("VERY_STRONG");
            } else if (cnt >= 60) {
                System.out.println("STRONG");
            } else if (cnt >= 50) {
                System.out.println("AVERAGE");
            } else if (cnt >= 25) {
                System.out.println("WEAK");
            } else {
                System.out.println("VERY_WEAK");
            }

        }
    }

    public static boolean hasZiMu(String str) {
        for (char c : str.toCharArray()) {
            if (isZiMu(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasXiaoXieZiMu(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (isXiaoXieZiMu(c)) {
                cnt++;
            }
        }
        return cnt == str.length();
    }

    public static boolean hasDaXieZiMu(String str) {
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (isDaXieZiMu(c)) {
                cnt++;
            }
        }
        return cnt == str.length();
    }

    public static boolean isSpecialCode(char c) {
        return c >= 0x21 && c <= 0x2F || c >= 0x3A && c <= 0x40 || c >= 0x5B && c <= 0x60 || c >= 0x7B && c <= 0x7E;
    }

    public static boolean isDaXieZiMu(char c) {
        return c >= 'A' && c <= 'Z';

    }

    public static boolean isXiaoXieZiMu(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isZiMu(char c) {
        return isDaXieZiMu(c) || isXiaoXieZiMu(c);
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}
