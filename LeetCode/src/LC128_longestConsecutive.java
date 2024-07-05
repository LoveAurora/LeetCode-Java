import java.util.Arrays;

public class LC128_longestConsecutive {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        LC128_longestConsecutive solution = new LC128_longestConsecutive();
        System.out.println(solution.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; // skip duplicates (e.g. [1,2,0,1] -> [0,1,1,2]
            else if (nums[i] == nums[i - 1] + 1) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}
