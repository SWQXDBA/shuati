import java.util.Scanner;

//标点不倒置
//I LIKE BEIJING.变成 BEIJING. LIKE I
public class 单词倒置 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            stringBuilder.append(strs[i]);
            if (i != 0)
                stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());

    }
}
