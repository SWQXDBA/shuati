public class Main2 {
    public static void main(String[] args) {
        String str = "aa";

    }

    public int reverse(int x) {
        if (x == 0)
            return 0;
        boolean flag = x > 0;
        int index = flag ? 0 : 1;
        String str = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        if (!flag) {
            stringBuilder.append("-");
        }
        for (int i = str.length(); i >= index; i++) {
            stringBuilder.append(i);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
