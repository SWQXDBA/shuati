import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String[] small = {"qwe", "keke", "chen", "qiqi", "guoo", "zeze", "yuyu", "mama", "heng", "jiee", "hand", "some"};
        String[] big = {"aaaa", "bbbb", "cccc", "dddd", "eeee", "ffff", "gggg", "hhhh", "iiii", "jjjj", "kkkk"};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int k = 0; k < n; k++) {
                String str = scanner.nextLine();
                char start = str.toCharArray()[0];
                if (start >= 0 && start <= 9) {
                    char[] chars = str.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (i < chars.length - 1) {
                            if (chars[i] == 1 && chars[i + 1] <= 2) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(chars[i]);
                                stringBuilder.append(chars[i + 1]);
                                int num = Integer.parseInt(stringBuilder.toString());
                                System.out.print(big[num - 1]);
                                i++;
                            } else {
                                int num = chars[i] - '0';
                                System.out.print(small[num - 1]);
                            }
                        }
                        if (i != chars.length - 1) {
                            System.out.print(",");
                        }
                    }
                }
            }

        }
    }
}
