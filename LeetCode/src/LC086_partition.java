public class LC086_partition {
    public ListNode partition(ListNode head, int x) {
        // 两次扫描，第一次找比x小的，第二次找大于等于x的
        if (head == null) return null;
        ListNode cur = head;
        ListNode dummy = new ListNode();
        ListNode flag = dummy;
        ListNode temp;
        while (true) {
            if (cur.val < x) {
                temp = new ListNode(cur.val);
                dummy.next = temp;
                dummy = dummy.next;
            }
            if (cur.next != null)
                cur = cur.next;
            else
                break;
        }
        cur = head;
        while (true) {
            if (cur.val >= x) {
                temp = new ListNode(cur.val);
                dummy.next = temp;
                dummy = dummy.next;
            }
            if (cur.next != null)
                cur = cur.next;
            else {
                break;
            }
        }
        return flag.next;
    }
}
