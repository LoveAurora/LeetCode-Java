public class LC082_removeDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }


    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        int index = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else if (fast - slow == 1) {
                nums[index++] = nums[slow];
                slow = fast;
            } else {
                nums[index++] = nums[slow];
                nums[index++] = nums[slow];
                slow = fast;
            }
        }
        // 由nums[slow] == nums[fast]知，如果[x,x,x,x,1]或者[x,x,x,x,1,1,1]都无法处理最后一个相同的数字
        // 所以要在处理一次这个特殊情况
        if (fast - slow == 1) {
            nums[index++] = nums[slow];
        } else if (fast - slow > 1) {
            nums[index++] = nums[slow];
            nums[index++] = nums[slow];
        }
        // index 是从0开始的，数组长度等于index + 1， 但是最后一次nums[index++] = nums[slow];已经把index+1了
        // 所以直接返回index
        return index;
    }
}
