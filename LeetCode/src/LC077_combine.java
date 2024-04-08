import java.util.ArrayList;
import java.util.List;

public class LC077_combine {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tempList = new ArrayList<>();
        int[] nums = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(res, tempList, nums, k, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(tempList)); // 添加当前组合到结果集中
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // 将当前元素添加到组合中
            backtrack(result, tempList, nums, k - 1, i + 1); // 递归调用 backtrack，选取下一个元素
            tempList.remove(tempList.size() - 1); // 回溯，移除最后一个元素
        }
    }
}
