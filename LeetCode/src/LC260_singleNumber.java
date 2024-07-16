import java.util.HashSet;

public class LC260_singleNumber {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int element : set) {
            result[i] = element;
            i++;
        }
        return result;
    }
}
