public class LC064_minPathSum {
    public static void main(String[] args) {
        // 初始化一个二维数组作为输入
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        // 调用minPathSum方法并打印结果
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        // 获取开始时间
        long startTime = System.nanoTime();

        // 获取网格的行数和列数
        int m = grid.length;
        int n = grid[0].length;
        // 如果网格只有一个元素，直接返回该元素
        if (m == 1 && n == 1)
            return grid[n - 1][m - 1];
        // 初始化一个二维数组，用于存储到达每个单元格的最小路径和
        int[][] dp = new int[m][n];
        // 遍历网格中的每个单元格
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                // 如果是左上角的单元格，最小路径和就是单元格的值
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                // 如果单元格在第一行，最小路径和是左边单元格的最小路径和加上当前单元格的值
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                // 如果单元格在第一列，最小路径和是上面单元格的最小路径和加上当前单元格的值
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                // 对于其他单元格，最小路径和是左边单元格和上面单元格的最小路径和中的较小值加上当前单元格的值
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

        // 获取结束时间
        long endTime = System.nanoTime();

        // 计算并打印运行时间
        long duration = (endTime - startTime) / 1000000;  // 转换为毫秒
        System.out.println("Execution time: " + duration + " ms");

        // 返回右下角单元格的最小路径和，即整个网格的最小路径和
        return dp[m - 1][n - 1];
    }
}