package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 迷宫问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            int[][] maze = new int[x][y];
            boolean[][] isWorked = new boolean[x][y];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    maze[i][j] = scanner.nextInt();
                    isWorked[i][j] = false;
                }
            }
            //这个其实用栈会更优雅一些
            List<Point> ways = new ArrayList<>();
            getWay(isWorked, maze, 0, 0, ways);
            for (Point p : ways) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }

        }
    }

    static boolean getWay(boolean[][] isWorked, int[][] maze, int x, int y, List<Point> lastway) {
        if (!isValuable(maze.length, maze[0].length, x, y))
            return false;
        if (isWorked[x][y] || maze[x][y] == 1)
            return false;

        Point tp = new Point(x, y);
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            lastway.add(tp);
            return true;
        }
        //标记这一步为已走过
        isWorked[x][y] = true;
        lastway.add(tp);
        if (getWay(isWorked, maze, x + 1, y, lastway)) {
            return true;
        } else if (getWay(isWorked, maze, x, y + 1, lastway)) {
            return true;
        } else if (getWay(isWorked, maze, x - 1, y, lastway)) {
            return true;
        } else if (getWay(isWorked, maze, x, y - 1, lastway)) {
            return true;
        } else {
            //此时都走不通 说明走到这一步就是个错误的选择,将这一步标记为没走过，同时取出这个格子 返回上一步
            isWorked[x][y] = false;
            lastway.remove(tp);
            return false;

        }

    }

    static boolean isValuable(int x, int y, int i, int j) {
        return i >= 0 && j >= 0 && i < x && j < y;
    }

    static boolean isOver(List<Point> way, int i, int j) {
        for (Point p : way) {
            if (p.x == i && p.y == j)
                return true;
        }
        return false;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
