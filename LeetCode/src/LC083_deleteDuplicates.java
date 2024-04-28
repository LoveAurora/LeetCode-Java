public class LC083_deleteDuplicates {
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1,new ListNode(2));
        // 删除重复节点
        ListNode result = deleteDuplicates(head);
        // 打印结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * 删除链表中的重复节点
     * @param head 链表的头节点
     * @return 删除重复节点后的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 如果链表为空，直接返回null
        if (head == null)
            return null;
        // 初始化当前节点
        ListNode current = head;
        // 遍历链表
        while (current.next != null) {
            // 如果当前节点和下一个节点的值相同，删除下一个节点
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // 否则，移动到下一个节点
                current = current.next;
            }
        }
        // 返回处理后的链表
        return head;
    }
}