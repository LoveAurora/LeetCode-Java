public class LC055_canJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false; // 到第i个位置，且i>k，说明无法到达
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
