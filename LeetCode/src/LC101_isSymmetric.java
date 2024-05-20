import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LC101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);

    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (right == null || left == null)
            return false;
        else if (left.val != right.val) return false;
        else return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
