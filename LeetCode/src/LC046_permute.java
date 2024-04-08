import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LC046_permute {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();
        for (int num : nums) {
            templist.add(num);
        }
        backtrack(result, templist, nums, 0, nums.length);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> templist, int[] nums, int start, int n) {
        if (start == n) {
            result.add(new ArrayList<>(templist));
        }
        for (int i = start; i < nums.length; i++) {
            // 动态维护数组
            Collections.swap(templist, start, i);
            // 继续递归填下一个数
            backtrack(result, templist, nums, start + 1, n);
            // 撤销操作
            Collections.swap(templist, start, i);
        }
    }
}
