import java.util.*;

public class LC047_permuteUnique {
    boolean[] vis; // 记录每个数字是否被访问过的数组

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new LC047_permuteUnique().permuteUnique(nums));
    }
    // 该方法用于求解包含重复元素的全排列
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); // 用于存储结果的列表
        List<Integer> perm = new ArrayList<Integer>(); // 用于存储当前排列的列表
        vis = new boolean[nums.length]; // 初始化标记数组，长度为给定数组的长度
        Arrays.sort(nums); // 对给定数组进行排序，为了后面判断重复元素是否访问过做准备
        backtrack(nums, ans, 0, perm); // 调用回溯算法求解全排列
        return ans; // 返回结果列表
    }

    // 回溯算法，用于求解全排列
    public void backtrack(int[] nums, List<List<Integer>> ans, int start, List<Integer> perm) {
        // 如果已经遍历到数组末尾，将当前排列加入到结果列表中
        if (start == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        // 遍历数组，依次将每个数字加入到当前排列中
        // 循环的下标每次都从0开始，保证即使跳过了一些数字也会保证每个数字都被访问
        // 循环结束也会回到上一个回调，也会恢复状态
        // 因为如果已经遍历到数组末尾，那经过回溯后最后访问的位置会被标记为false，此时倒数第二次递归的for循环的i应该为nums.length - 1，结束了循环跳出此次回溯，恢复状态
        // 倒数第二次递归的for里面的i为nums.length - 1，start用来记录递归的次数。此时的的start=nums.length - 1，
        // 最后一个被访问的数字状态回溯，倒数第二个被访问的数字由于for循环结束，跳出递归，状态回溯。
        for (int i = 0; i < nums.length; ++i) {
            // 如果当前数字已经被访问过，或者当前数字与前一个数字相同且前一个数字未被访问过，则跳过该数字
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            // 将当前数字加入到当前排列中，并标记为已访问
            perm.add(nums[i]);
            vis[i] = true;
            // 递归调用，继续填充下一个位置的数字
            backtrack(nums, ans, start + 1, perm);
            // 回溯操作，恢复状态
            vis[i] = false;
            perm.remove(start);
        }
    }










}
