public class LC221_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        // 初始化最大边长为0
        int maxSide = 0;
        // 如果矩阵为空或者矩阵的行或列为0，直接返回0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        // 获取矩阵的行数和列数
        int rows = matrix.length, columns = matrix[0].length;
        // 初始化动态规划数组
        int[][] dp = new int[rows][columns];
        // 遍历矩阵
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 如果当前元素为'1'，则进行处理
                if (matrix[i][j] == '1') {
                    // 如果当前元素在矩阵的边界上，那么以它为右下角的最大正方形的边长就是1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 否则，以它为右下角的最大正方形的边长是它的左上、上、左三个邻居的最小边长+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 更新最大边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        // 计算最大正方形的面积
        int maxSquare = maxSide * maxSide;
        // 返回最大正方形的面积
        return maxSquare;
    }
}