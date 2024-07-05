public class LC209_minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < len) {
            sum = sum + nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
