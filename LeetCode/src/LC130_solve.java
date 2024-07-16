public class LC130_solve {
    int n, m; // n 和 m 用于存储棋盘的尺寸（n = 行数，m = 列数）

    public void solve(char[][] board) {
        n = board.length; // 初始化 n 为棋盘的行数
        if (n == 0) { // 如果棋盘为空，则立即返回
            return;
        }
        m = board[0].length; // 初始化 m 为棋盘的列数

        // 从边界进行深度优先搜索（DFS），找出不被 'X' 包围的 'O'
        for (int i = 0; i < n; i++) { // 遍历每一行
            dfs(board, i, 0); // 从左边界开始 DFS
            dfs(board, i, m - 1); // 从右边界开始 DFS
        }
        for (int i = 1; i < m - 1; i++) { // 遍历每一列，不包括边界
            dfs(board, 0, i); // 从上边界开始 DFS
            dfs(board, n - 1, i); // 从下边界开始 DFS
        }

        // 将 'A' 替换为 'O'，将 'O' 替换为 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') { // 如果单元格标记为 'A'，表示它与边界相连，因此不被 'X' 包围
                    board[i][j] = 'O'; // 将 'A' 替换为 'O'
                } else if (board[i][j] == 'O') { // 如果单元格为 'O'，表示它被 'X' 包围
                    board[i][j] = 'X'; // 将 'O' 替换为 'X'
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        // DFS 的基本条件判断
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') { // 如果越界或单元格不是 'O'，则返回
            return;
        }
        board[x][y] = 'A'; // 将单元格标记为 'A'，表示它与边界相连，不被 'X' 包围
        // 递归调用 dfs 对所有相邻单元格进行搜索
        dfs(board, x + 1, y); // 向下
        dfs(board, x - 1, y); // 向上
        dfs(board, x, y + 1); // 向右
        dfs(board, x, y - 1); // 向左
    }
}