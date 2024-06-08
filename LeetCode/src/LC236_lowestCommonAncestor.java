public class LC236_lowestCommonAncestor {
    /**
     * 寻找二叉树中两个节点的最近公共祖先
     *
     * @param root 二叉树的根节点
     * @param p    第一个节点
     * @param q    第二个节点
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q)
            return root;
        // 在左子树中寻找p和q的最近公共祖先
        // left 来接收左子树的结果，pq不在里面left就为空，否则为p或者q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中寻找p和q的最近公共祖先
        // left 来接收右子树的结果，pq不在里面right就为空，否则为p或者q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树和右子树都找到了结果，那么最近公共祖先就是根节点
        if (left != null && right != null)
            return root;
        // 如果左子树找到了结果，那么最近公共祖先就是左子树的结果
        // 上一级递归的left就有结果了
        if (left != null)
            return left;
        // 否则，最近公共祖先就是右子树的结果
        // 上一级递归的right就有结果了
        return right;
    }
}