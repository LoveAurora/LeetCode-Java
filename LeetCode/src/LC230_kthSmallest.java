public class LC230_kthSmallest {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return Integer.MAX_VALUE; // 修改返回值以避免误导

        int leftResult = kthSmallest(root.left, k);
        if (leftResult != Integer.MAX_VALUE) return leftResult; // 已在左子树找到

        count++;
        if (count == k) return root.val; // 找到第k小的元素

        return kthSmallest(root.right, k); // 继续在右子树查找
    }

}
