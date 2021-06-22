import java.util.Scanner;

class Main {

    static boolean[][] finded;
    static boolean isOk = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean Find = false;
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            scanner.nextLine();
            String[][] matrix = new String[m][n];
            for (int i = 0; i < m; i++) {
                String str = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = str.split("")[j];
                }
            }

            for (int i = 0; i < m && !Find; i++) {
                for (int j = 0; j < n && !Find; j++) {
                    finded = new boolean[m][n];
                    isOk = false;
                    dfs(matrix, i, j);
                    if (!isOk && !matrix[i][j].equals("#")) {
                        pushWater(matrix, i, j);
                        Find = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
                }
                if (i != m - 1)
                    System.out.println();
            }

        }

    }

    static void dfs(String[][] matrix, int m, int n) {
        if (!isValuable(matrix, m, n)) {
            isOk = true;
            return;
        }

        if (finded[m][n]) {
            return;
        }
        finded[m][n] = true;
        if (matrix[m][n].equals("#")) {
            return;
        }
        dfs(matrix, m + 1, n);
        dfs(matrix, m, n + 1);
        dfs(matrix, m - 1, n);
        dfs(matrix, m, n - 1);
    }

    static void pushWater(String[][] matrix, int m, int n) {
        if (!matrix[m][n].equals("#") && !matrix[m][n].equals("&")) {
            matrix[m][n] = "&";
            pushWater(matrix, m - 1, n);
            pushWater(matrix, m + 1, n);
            pushWater(matrix, m, n - 1);
            pushWater(matrix, m, n + 1);
        }
    }

    static boolean isValuable(String[][] matrix, int m, int n) {
        if (m >= matrix.length || n >= matrix[0].length || n < 0 || m < 0) {
            return false;
        }
        return true;
    }


}

