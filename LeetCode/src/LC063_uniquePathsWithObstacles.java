public class LC063_uniquePathsWithObstacles {
    public static void main(String[] args) {
        // 测试方法uniquePathsWithObstacles
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 获取网格的行数和列数
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // 如果起点有障碍物，直接返回0
        if (obstacleGrid[0][0] == 1)
            return 0;
        // 如果网格只有一个元素，直接返回该元素
        else if (m == 1 && n == 1)
            return 1;
        // 初始化一个二维数组，用于存储到达每个单元格的路径数量
        int[][] result = new int[n][m];
        // 遍历网格中的每个单元格
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果是左上角的单元格，路径数量为1
                if (i == 0 && j == 0) {
                    result[i][j] = 1;
                }
                // 如果单元格在第一行且没有障碍物，路径数量等于左边单元格的路径数量
                else if (i == 0 && obstacleGrid[i][j] == 0) {
                    if (result[i][j - 1] == 0)
                        result[i][j] = 0;
                    else
                        result[i][j] = result[i][j - 1];
                }
                // 如果单元格在第一列且没有障碍物，路径数量等于上面单元格的路径数量
                else if (j == 0 && obstacleGrid[i][j] == 0) {
                    if (result[i - 1][j] == 0)
                        result[i][j] = 0;
                    else
                        result[i][j] = result[i - 1][j];
                }
                // 对于其他没有障碍物的单元格，路径数量是左边单元格和上面单元格的路径数量之和
                else if (obstacleGrid[i][j] == 0) {
                    if (result[i - 1][j] == 0)
                        result[i][j] = result[i][j - 1];
                    else if (result[i][j - 1] == 0)
                        result[i][j] = result[i - 1][j];
                    else
                        result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
                // 对于有障碍物的单元格，路径数量为0
                else {
                    result[i][j] = 0;
                }
            }
            // 打印当前的路径数量
            System.out.println(result[n - 1][m - 1] != 0 ? result[n - 1][m - 1] : 0);
        }
        // 返回右下角单元格的路径数量，即整个网格的路径数量
        return result[n - 1][m - 1];
    }
}