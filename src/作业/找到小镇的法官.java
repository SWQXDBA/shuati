package 作业;

public class 找到小镇的法官 {
    static public int findJudge(int n, int[][] trust) {
        int x = trust.length;
        int[][] tst = new int[n][2];
        for (int i = 0; i < x; i++) {
            tst[trust[i][0] - 1][0]++;
            tst[trust[i][1] - 1][1]++;
        }
        for (int i = 0; i < n; i++) {
            if (tst[i][1] == n - 1 && tst[i][0] == 0)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(3, grid));
    }
}
