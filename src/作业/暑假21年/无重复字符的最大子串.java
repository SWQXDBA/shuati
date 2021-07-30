package 作业.暑假21年;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最大子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (left < s.length() && right < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            //此时代表右指针指向的元素重复了
            //此时 让左指针移动到重复的后一个元素然后让右指针继续搜索
            //(abc)bdf->a(cbdf)
            max = Math.max(max, right - left);
            while (right < s.length() && s.charAt(left) != s.charAt(right)) {
                set.remove(s.charAt(left));
                left++;
            }
            left++;//让左指针移动到重复的后一个元素
            right++;//因为此时右指针所在的元素已经被加入了集合中 !set.contains(s.charAt(right) ，所以右指针从下一个地方开始
        }

        return max;
    }

}
