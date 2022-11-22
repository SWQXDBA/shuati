package 作业.暑假21年;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最常见的单词 {
    static public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace("!", " ");
        paragraph = paragraph.replace(".", " ");
        paragraph = paragraph.replace("?", " ");
        paragraph = paragraph.replace(";", " ");
        paragraph = paragraph.replace("'", " ");
        Set<String> ban = new HashSet<>();
        for (String s : paragraph.split(" ")) {
            s = s.toLowerCase();
            s = s.trim();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : banned) {
            ban.add(s);
        }
        String max = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (ban.contains(entry.getKey()) || entry.getKey().equals("")) {
                continue;
            }
            if (entry.getValue() >= maxCount) {
                max = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "Bob. hIt, baLl";
        String[] ban = {"bob", "hit"};
        System.out.println(mostCommonWord(s, ban));
    }
}
