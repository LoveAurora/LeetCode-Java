public class LC082_deleteDuplicates {
    public static void main(String[] args) {
        // 初始化一个链表进行测试
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4))))));
        // 调用deleteDuplicates方法并打印结果
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode();
        // 创建一个当前节点，用于构建新的链表
        ListNode current = dummy;

        // 创建两个指针，一个快指针和一个慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 如果头节点为空，直接返回null
        if (head == null)
            return null;

        // 当快指针的下一个节点不为空时，进行循环
        while (fast.next != null) {
            // 如果快指针和快指针的下一个节点的值相等，快指针向前移动一步
            if (fast.val == fast.next.val) {
                fast = fast.next;
            }
            // 如果慢指针和快指针的值相等，并且它们不是同一个节点，快慢指针都向前移动一步
            else if (slow.val == fast.val && !slow.equals(fast)) {
                fast = fast.next;
                slow = fast;
            }
            // 如果以上条件都不满足，将快指针的值添加到新的链表中，然后快慢指针都向前移动一步
            else {
                current.next = new ListNode(fast.val);
                current = current.next;
                fast = fast.next;
                slow = fast;
            }
        }
        // 处理类似与1，1，2这种特殊情况，此时fast==slow是最后一个节点，由于while的判断条件是 fast.next != null 所以会跳出循环
        // 需要将最后一个节点的值添加到新的链表中
        if (slow == fast) {
            current.next = new ListNode(fast.val);
        }
        // 返回新链表的头节点
        return dummy.next;
    }
}