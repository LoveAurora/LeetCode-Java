public class LC104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 定义变量接受左右子树的深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
