import java.util.Arrays;

/**
 * @author SWQXDBA
 */
public class Main {
    public static void fun(IMessage iMessage, String str) {
        iMessage.send(str);
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5};
        for (int i : arr) {
            i = i + 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public int numberOfChar(String str, char c) {
        int cnt = 0;
        for (char c1 : str.toCharArray()) {
            if (c1 == c) {
                cnt++;
            }
        }
        return cnt;
    }

    public String solve(String IP) {
        if (IP.contains(".")) {
            final String[] split = IP.split("\\.");
            if (split.length != 4 || numberOfChar(IP, '.') != 3) {
                return "Neither";
            }

            for (String s : split) {
                try {
                    final int integer = Integer.parseInt(s);
                    if (integer < 0 || integer > 255 || s.startsWith("0")) {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
            return "IPv4";

        } else if (IP.contains(":")) {
            final String[] split = IP.split(":");
            if (split.length != 8 || numberOfChar(IP, ':') != 7) {
                return "Neither";
            }

            for (String s : split) {
                try {
                    final int integer = Integer.valueOf(s, 16);
                    if (integer < 0 || integer > Integer.valueOf("FFFF", 16) || s.length() > 4) {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    interface IMessage {                                    // 定义接口
        public void send(String str);                        // 抽象方法
    }
}

