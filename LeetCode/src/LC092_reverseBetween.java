public class LC092_reverseBetween {
    public static void main(String[] args) {
        // 创建一个链表并调用reverseBetween方法进行反转，然后打印结果
        System.out.println(reverseBetween(new ListNode(1, new ListNode(2)), 1, 2));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) return head;
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0, head);
        // 创建一个前置节点，用于跟踪需要反转的部分的前一个节点
        ListNode prev = dummy;
        // 将前置节点移动到需要反转的部分的前一个位置
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 创建一个当前节点，用于跟踪需要反转的部分的第一个节点
        ListNode current = prev.next;
        // 进行反转
        for (int i = 0; i < right - left; i++) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        // 返回新链表的头节点
        return dummy.next;
    }
}