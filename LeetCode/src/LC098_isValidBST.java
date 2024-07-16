import java.util.ArrayList;
import java.util.List;

public class LC098_isValidBST {
    private List<Integer> list = new ArrayList<>();
    int[] res = new int[10000];
    int count = 0;
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (max != null && root.val <= max.val) return false;
        max = root;
        boolean right = isValidBST(root.right);
        return right;
    }

    public boolean isValidBSTNew(TreeNode root) {
        if (root == null) return false;
        inorder(root);
        for (int i = 1; i < count; i++) {
            if (res[i] <= res[i - 1]) return false;
        }
        return true;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res[count++] = root.val;
        inorder(root.right);
    }
}
