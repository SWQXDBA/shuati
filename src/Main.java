public class Main {

    public Main(int a) {


    }

    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
        b3 = (byte) (b1 + b2);
        System.out.println(b3 + b6);


    }

    public boolean checkWon(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1 || board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
                return true;
            }
        }
        if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 || board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
            return true;
        }
        return false;
    }


}

