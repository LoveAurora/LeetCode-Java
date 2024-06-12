import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC042_trap {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {

            List<Integer> temp = new ArrayList<>();

            if (stack.isEmpty() || stack.peek() > height[i]) {
                stack.push(i);
            }
            // 如果当前高度大于栈顶高度，说明可以形成凹槽
            while (!stack.isEmpty() && stack.peek() <= height[i]) {
                temp.add(stack.pop());
            }

            for (int j = 0; j < temp.size() - 1; j++) {
                res += (Math.min(height[temp.get(0)], height[i]) - height[temp.get(j + 1])) * (i - temp.get(j + 1) - 1);
            }
        }
        return res;
    }
}
