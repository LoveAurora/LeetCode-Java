import java.util.LinkedList;
import java.util.Queue;

public class LC111_minDepth {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int minNum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            minNum += 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return minNum;
                else if (node.left != null || node.right != null) {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }
        return minNum;
    }


}
