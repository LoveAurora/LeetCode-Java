public class LC189_rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // Ensure k is within the bounds of the array length
        k = k % len;
        int[] temp = new int[len];
        // Loop through the array and calculate new positions based on rotation
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        // Copy the rotated elements back into the original array
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}