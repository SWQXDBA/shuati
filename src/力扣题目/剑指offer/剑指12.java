package 力扣题目.剑指offer;

public class 剑指12 {
    static boolean[][] findIndex;

    static public boolean exist(char[][] board, String word) {
        boolean ret = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findIndex = new boolean[board.length][board[0].length];
                ret = ret || dfs(board, word, 0, i, j);
                if (ret)
                    return ret;
            }
        }
        return ret;
    }

    static boolean dfs(char[][] board, String word, int index, int m, int n) {
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length || index >= word.length() || findIndex[m][n])
            return false;

        boolean ret = board[m][n] == word.charAt(index);
        if (ret) {
            findIndex[m][n] = true;
            if (index == word.length() - 1)
                return true;
            ret = dfs(board, word, index + 1, m - 1, n) || dfs(board, word, index + 1, m, n - 1) || dfs(board, word, index + 1, m + 1, n) ||
                    dfs(board, word, index + 1, m, n + 1);
        }
        if (!ret)
            findIndex[m][n] = false;
        return ret;

    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCESEEEFS"));
//                    char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
//                    System.out.println(exist(board,"abcced"));
    }
}
