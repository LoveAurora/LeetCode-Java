import java.util.*;

public class LC040_combinationSum {
    public static void main(String[] args) {
        //int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] candidates = {1, 2, 2, 2, 3};
        System.out.println(combinationSum2(candidates, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();
        backtrack(result, templist, candidates, target, 0);
        return result;
    }

    public static void backtrack(  List<List<Integer>> result, List<Integer> templist, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(templist));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            if (!set.add(candidates[i])) continue;
            //  如果在set集合中已经有，也越过。同层剪枝 考虑[1,2,2,2,3] target=5的例子
            // 每一次递归创建了一个set，相同的层次set相同,同一个start代表同一个层次。
            templist.add(candidates[i]);
            backtrack(result, templist, candidates, target - candidates[i], i + 1);
            templist.remove(templist.size() - 1);
        }
    }

}
