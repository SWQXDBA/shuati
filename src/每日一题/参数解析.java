package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 参数解析 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            boolean inMode = false;
            List<String> list = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (!inMode) {
                    if (c == '"') {//进入""
                        inMode = true;
                        continue;
                    }
                    if (c != ' ') {
                        current.append(c);
                    } else {
                        list.add(current.toString());
                        current = new StringBuilder();
                    }
                } else {
                    if (c == '"') {//出""
                        inMode = false;
                        continue;
                    }
                    current.append(c);
                }
            }
            list.add(current.toString());
            System.out.println(list.size());
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
