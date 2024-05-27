public class LC226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode prev = root.left;
        root.left = root.right;
        root.right = prev;
        return root;
    }
}
