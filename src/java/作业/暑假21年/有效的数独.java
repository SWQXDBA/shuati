package 作业.暑假21年;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> hang = new ArrayList<>();
        List<HashSet<Character>> lie = new ArrayList<>();
        List<HashSet<Character>> box = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            hang.add(new HashSet<>());
            lie.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int indexInBox = (i / 3) * 3 + j / 3;

                HashSet<Character> h = hang.get(i);//取得这一行的set
                HashSet<Character> l = lie.get(j);//取得这一列的set
                HashSet<Character> b = box.get(indexInBox);//取得这一子九宫格的set
                if (h.contains(c) || l.contains(c) || b.contains(c)) {
                    return false;
                }
                h.add(c);
                l.add(c);
                b.add(c);
            }
        }
        return true;
    }
}
