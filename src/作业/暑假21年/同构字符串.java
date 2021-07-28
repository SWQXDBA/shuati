package 作业.暑假21年;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    static public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }

        }
        return true;
    }
}

