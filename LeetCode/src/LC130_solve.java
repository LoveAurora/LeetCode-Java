public class LC130_solve {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        char[][] result = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (board[i-1][j] == 'X' && board[i+1][j] == 'X'&& board[i][j-1] == 'X' && board[i][j+1] == 'X' ){

                    }

                } else {
                    result[i][j] = 'A';
                }
            }
        }
    }
}
