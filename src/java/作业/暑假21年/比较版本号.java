package 作业.暑假21年;

public class 比较版本号 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("014"));
    }

    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        long length = Math.max(vs1.length, vs2.length);//判断最长应该有几位
        long vs1Num = 0, vs2Num = 0;
        for (String s : vs1) {
            vs1Num += Long.parseLong(s);
            vs1Num *= 10;
        }
        vs1Num /= 10;
        for (long i = vs1.length; i < length; i++) {
            vs1Num *= 10;
        }
        for (String s : vs2) {
            vs2Num += Long.parseLong(s);
            vs2Num *= 10;
        }
        vs2Num /= 10;
        for (long i = vs2.length; i < length; i++) {
            vs2Num *= 10;
        }
        if (vs1Num > vs2Num) {
            return 1;
        } else if (vs1Num < vs2Num) {
            return -1;
        }
        return 0;

    }
}
