package 作业;

import java.util.ArrayList;
import java.util.List;

public class 二维网格迁移 {
    static public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] tempgrid = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int ymove = j + k % y;
                int xmove = i + k / y;
                if (ymove > y - 1) {
                    ymove %= y;
                    xmove++;
                }
                if (xmove > x - 1) {
                    xmove %= x;
                }
                tempgrid[xmove][ymove] = grid[i][j];
            }
        }
        List<List<Integer>> newGrid = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                row.add(tempgrid[i][j]);
            }
            newGrid.add(row);
        }
        return newGrid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}, {2}, {3}, {4}, {5}, {6}, {7}};
        List<List<Integer>> list = shiftGrid(grid, 23);
        for (List<Integer> i : list) {
            for (Integer j : i) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
