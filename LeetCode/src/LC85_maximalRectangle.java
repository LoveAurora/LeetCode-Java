import java.util.Stack;

public class LC85_maximalRectangle {

    public static void main(String[] args) {
        char[][] array = {
                {'0', '0', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '1', '1'}
        };
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new LC85_maximalRectangle().maximalRectangle(array));
    }

    //   这个方法只能找到正方形的最大面积
//    public int maximalRectangle(char[][] matrix) {
//        int[][] temp = new int[matrix.length][matrix[0].length];
//        int res = 0;
//        int column = matrix[0].length, row = matrix.length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                if (j == 0 && i == 0) {
//                    temp[i][j] = matrix[i][j] - '0';
//                    res = Math.max(res, temp[i][j]);
//                } else if (i == 0) {
//                    if (matrix[i][j] == '0')
//                        temp[i][j] = 0;
//                    else
//                        temp[i][j] = temp[i][j - 1] + matrix[i][j] - '0';
//                    res = Math.max(res, temp[i][j]);
//                } else if (j == 0) {
//                    if (matrix[i][j] == '0')
//                        temp[i][j] = 0;
//                    else
//                        temp[i][j] = temp[i - 1][j] + matrix[i][j] - '0';
//                    res = Math.max(res, temp[i][j]);
//                } else {
//                    if (matrix[i][j] == '0') {
//                        temp[i][j] = 0;
//                    } else if (matrix[i][j] == '1') {
//                        if (temp[i - 1][j - 1] == 0) {
//                            temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]) + 1;
//                        }else {
//                            temp[i][j] = temp[i - 1][j] + temp[i][j - 1] - temp[i - 1][j - 1] + 1;
//                        }
//                        res = Math.max(res, temp[i][j]);
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return res;
//    }
    public int maximalRectangle(char[][] matrix) {
        // 如果矩阵为空，则直接返回0
        if (matrix.length == 0) return 0;

        // 获取矩阵的行数和列数
        int row = matrix.length, column = matrix[0].length;

        // 初始化一个heights二维数组，用来存储每个位置向上累加的'1'的数量
        int[][] heights = new int[row][column];

        // 初始化最大矩形面积为0
        int maxArea = 0;

        // 计算heights数组
        // 遍历矩阵的每一行
        for (int i = 0; i < row; i++) {
            // 对于每一行，如果当前元素为'1'，则累加前一行的高度加1，否则高度为0
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                } else {
                    // 如果不是第一行，当前高度等于上一行同一列的高度加1
                    heights[i][j] = (i == 0) ? 1 : heights[i - 1][j] + 1;
                }
            }
        }

        // 对每一行的高度数组，使用largestRectangleArea方法计算最大矩形面积，并更新maxArea
        for (int i = 0; i < row; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));
        }

        // 返回找到的最大矩形面积
        return maxArea;
    }

    // 辅助方法：计算给定高度数组中的最大矩形面积
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // 遍历高度数组，包括一个额外的0高度元素，确保栈能够完全清空
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            // 当栈顶的高度大于当前高度时，开始计算矩形面积
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // 取出栈顶高度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // 计算宽度
                maxArea = Math.max(maxArea, height * width); // 更新最大面积
            }

            // 将当前高度的索引入栈
            stack.push(i);
        }

        // 返回最大矩形面积
        return maxArea;
    }

    public int calculateMaxRectangleAreaByExpandingUpwards(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新 width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

}
