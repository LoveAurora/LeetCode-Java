import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

public class LC001_twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        LC001_twoSum res = new LC001_twoSum();
        int[] result = res.twoSum(nums, 9);
        System.out.println(result.length);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                return new int[]{hashmap.get(target - nums[i]), i};
            }
            hashmap.put(nums[i], i);
        }
        return new int[0];
    }

}