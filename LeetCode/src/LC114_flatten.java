public class LC114_flatten {
    TreeNode temp = new TreeNode();
    TreeNode dummy = temp;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        LC114_flatten lc114_flatten = new LC114_flatten();
        lc114_flatten.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }

    }

    // 这个方法不行 Java语言不支持引用传递  root = dummy.right; 改变不了root
//    public void flatten(TreeNode root) {
//        TreeNode[] wrapper = new TreeNode[1]; // 包装对象
//        wrapper[0] = root; // 将 root 放入包装对象中
//        dfs(wrapper);
//        root = dummy.right;
//    }
//
//    public void dfs(TreeNode[] rootWrapper) { // 修改参数类型为包装对象
//        TreeNode root = rootWrapper[0]; // 从包装对象中取出 root
//        if (root == null)
//            return;
//        TreeNode treeNode = new TreeNode(root.val);
//        temp.right = treeNode;
//        temp.left = null;
//        temp = temp.right;
//        dfs(new TreeNode[]{root.left}); // 传递包装对象
//        dfs(new TreeNode[]{root.right}); // 传递包装对象
//    }
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        // 如果 root 为 null，直接返回
        if (root == null)
            return;
        // 先展平右子树
        flatten(root.right);
        // 再展平左子树
        flatten(root.left);
        // 将展平后的左子树接到右子树上，左子树设为 null
        root.right = prev;
        root.left = null;
        // 更新 prev 节点
        prev = root;
    }

}
