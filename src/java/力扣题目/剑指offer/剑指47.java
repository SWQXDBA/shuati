package 力扣题目.剑指offer;

public class 剑指47 {
    static int[][] res;

    static public int maxValue(int[][] grid) {
        res = new int[grid.length][grid[0].length];
        return getMax(grid, 0, 0);
    }

    static int getMax(int[][] grid, int x, int y) {

        if (x == grid.length || y == grid[0].length)
            return 0;
        if (x == grid.length - 1 && y == grid[0].length - 1)
            return grid[x][y];
        int ret;
        if (res[x][y] == 0) {
            ret = Math.max(getMax(grid, x + 1, y), getMax(grid, x, y + 1)) + grid[x][y];
            res[x][y] = ret;
        } else {
            ret = res[x][y];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(nums));
    }
}
