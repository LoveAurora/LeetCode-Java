public class LC064_minPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        // 获取开始时间
        long startTime = System.nanoTime();

        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1)
            return grid[n - 1][m - 1];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

        // 获取结束时间
        long endTime = System.nanoTime();

        // 计算并打印运行时间
        long duration = (endTime - startTime) / 1000000;  // 转换为毫秒
        System.out.println("Execution time: " + duration + " ms");

        return dp[m - 1][n - 1];
    }
}