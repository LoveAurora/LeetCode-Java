import java.util.ArrayList;
import java.util.List;

public class LC112_pathSum {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<Integer>(temp));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        temp.remove(temp.size() - 1);

    }
}
