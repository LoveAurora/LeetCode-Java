import java.util.*;

public class LC042_trap {
    public static void main(String[] args) {
        // 测试数据
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        LC042_trap solution = new LC042_trap();

        // 打印结果
        System.out.println(solution.trap(height));
    }

    /**
     * 计算接雨水的总量
     * @param height 每个位置的高度
     * @return 接雨水的总量
     */
    public int trap(int[] height) {
        // 初始化结果
        int ans = 0;
        // 使用栈存储每个位置的索引
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        // 遍历每个位置
        for (int i = 0; i < n; ++i) {
            // 当栈不为空且当前位置的高度大于栈顶位置的高度时
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 弹出栈顶元素
                int top = stack.pop();
                // 如果栈为空，跳出循环 说明上一步弹出的是最后一个元素 无法接雨水
                // 处理边界情况 比如 [0, 1] 这种接不了雨水的情况
                if (stack.isEmpty()) {
                    break;
                }
                // 获取栈顶元素
                int left = stack.peek();
                // 计算宽度
                int currWidth = i - left - 1;
                // 计算高度
                int currHeight = Math.min(height[left], height[i]) - height[top];
                // 累加接雨水的量
                ans += currWidth * currHeight;
            }
            // 将当前位置入栈
            stack.push(i);
        }
        // 返回结果
        return ans;
    }
}