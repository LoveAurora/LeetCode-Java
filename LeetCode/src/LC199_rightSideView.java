import java.util.ArrayList;
import java.util.List;

public class LC199_rightSideView {
    /**
     * 从二叉树的右侧看，返回从顶部到底部的节点值
     * @param root 二叉树的根节点
     * @return 从右侧看到的节点值列表
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        DFS(root, 0, res);
        return res;
    }

    /**
     * 深度优先搜索
     * @param root 当前节点
     * @param depth 当前深度
     * @param res 结果列表
     */
    public static void DFS(TreeNode root, int depth, List<Integer> res) {
        // 如果节点为空，直接返回
        if (root == null) {
            return;
        }
        // 如果当前深度等于结果列表的大小，说明在这个深度的节点还没有添加到结果列表中，将当前节点添加到结果列表中
        if (depth == res.size()) {
            res.add(root.val);
        }
        // 先遍历右子树
        DFS(root.right, depth + 1, res);
        // 再遍历左子树
        DFS(root.left, depth + 1, res);
    }
}