package 每日一题;

public class 手套 {
    public static void main(String[] args) {
        int[] l = {0, 7, 1, 3};
        int[] r = {1, 5, 0, 6};
        System.out.println(findMinimum(4, l, r));

    }

    static int findMinimum(int n, int[] left, int[] right) {
        int leftSum = 0, rightSum = 0;
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
        int complete = 0; //需要从左右手套中多拿的数量
        for (int i = 0; i < n; i++) {
            if (left[i] * right[i] == 0)
                complete += (left[i] + right[i]);
            else {
                leftSum += left[i];
                rightSum += right[i];
                leftMin = Math.min(leftMin, left[i]);
                rightMin = Math.min(rightMin, right[i]);
            }
        }
        //complete为对方为单只的手套数量和
        //先排除这些只有单只的进行计算得到一个结果。
        //为了避免选中单只的手套而没选结果中的 要加上双方的单只手套数量、
        //比如4
        //0 7 1 6
        //1 5 0 6
        //此时算出双方最少选的是8（7+6-6+1）,7（5+6-5+1） 但是如果右手选了4号六个和1号一个 则二号不能选上，违背了每个颜色必然有一个的原则，此时左手选择二号配对则出错了。左手同理要加上三号的1个。如果只选了一个 则有可能只有三号 则必然不能配对（因为三号是单只的）
        return complete + Math.min(leftSum - leftMin + 1, rightSum - rightMin + 1) + 1;
    }

}
