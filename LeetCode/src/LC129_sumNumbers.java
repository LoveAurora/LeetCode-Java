import java.util.ArrayList;
import java.util.List;

public class LC129_sumNumbers {
    int res = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new LC129_sumNumbers().sumNumbers(root));
    }



    public int sumNumbers(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        dfs(root, temp);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> temp) {
        if (root == null) return;
        else if (root.left == null && root.right == null) {
            //  有 add 的地方就要有 remove   回溯操作
            temp.add(root.val);
            int sum = 0;
            for (int i = 0; i < temp.size(); i++) {
                sum = sum + (int) (temp.get(i) * Math.pow(10, temp.size() - i - 1));
            }
            res = res + sum;
            temp.remove(temp.size() - 1);
            return;
        } else {
            //  有 add 的地方就要有 remove  回溯操作
            temp.add(root.val);
            dfs(root.left, temp);
            dfs(root.right, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
