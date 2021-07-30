package 作业.暑假21年;

public class 比较字符串最小字母出现频次 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ret = new int[queries.length];
        int[] fValue = new int[11];//题目规定 <= queries[i].length, words[i].length <= 10
        //让fValue中最小字母的出现频次为i的有fValue[i]个
        for (String word : words) {
            fValue[func(word)]++;
        }
        int lastValue = fValue[10];
        fValue[10] = 0;//没有比最大的还大的了
        for (int i = 9; i >= 0; i--) {//进一步优化 让fValue[i]保存比i大的个数
            int t = fValue[i];//保存自己的数量 给低一位的数使用
            fValue[i] = lastValue + fValue[i + 1];//等于比上一位数大数量的加上上一位数本身的数量
            lastValue = t;//保存自己的数量 给低一位的数使用
        }
        for (int i = 0; i < queries.length; i++) {
            ret[i] = fValue[func(queries[i])];
        }
        return ret;
    }

    int func(String str) {
        int cnt = 0;
        char lowerWord = 'z';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == lowerWord) {
                cnt++;
            } else if (str.charAt(i) < lowerWord) {
                lowerWord = str.charAt(i);
                cnt = 1;
            }

        }

        return cnt;
    }


}
