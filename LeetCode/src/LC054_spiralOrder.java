import java.util.ArrayList;
import java.util.List;

public class LC054_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int len = matrix.length;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        if (len == 0) return result;
        int count = matrix.length * matrix[0].length;
        while (count > 0) {
            for (int i = left; i <= right && count > 0; i++) {
                result.add(matrix[left][i]);
                count--;
            }
            top++;
            for (int i = top; i <= bottom && count > 0; i++) {
                result.add(matrix[i][right]);
                count--;
            }
            right--;
            for (int i = right; i >= left && count > 0; i--) {
                result.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top && count > 0; i--) {
                result.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return result;
    }
}
