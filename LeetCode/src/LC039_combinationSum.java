import java.util.*;

public class LC039_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> templist = new ArrayList<>();
        backtrack(result, templist, candidates, target, 0);
        List<List<Integer>> resultlist = new ArrayList<>(result);
        return resultlist;
    }

    public static void backtrack(Set<List<Integer>> result, List<Integer> templist, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(templist));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            //如果在set集合中已经有，也越过。同层剪枝 考虑[1,2,2,2,3] target=5的例子
            // 每一次递归创建了一个set，相同的层次set相同。
            templist.add(candidates[i]);
            backtrack(result, templist, candidates, target - candidates[i], i);
            templist.remove(templist.size() - 1);
        }
    }

}
