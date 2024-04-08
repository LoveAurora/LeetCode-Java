public class LC034_searchRange {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 6;
        int[] result = new int[2];
        result = searchRange(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int mid = -1;
        int num = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                num = mid;
                break;
            }
        }
        System.out.println(mid);
        System.out.println(num);
        if (num != -1) {
            int low = num - 1, high = num + 1;
            while (low >= 0 && nums[low] == target) {
                low--;
            }
            low += 1;
            System.out.println(low);
            while (high < nums.length && nums[high] == target) {
                high++;
            }
            high -= 1;
            System.out.println(high);
            if (high - low >= 0) {
                result[0] = low;
                result[1] = high;
                return result;
            }
        }
        return result;

    }

}
