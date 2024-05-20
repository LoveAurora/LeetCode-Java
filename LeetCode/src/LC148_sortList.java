public class LC148_sortList {
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lastNode = head;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.val >= lastNode.val){
                lastNode = lastNode.next;
            }else{
                ListNode pre = dummy;
                while(pre.next.val <= curr.val){
                    pre = pre.next;
                }
                lastNode.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastNode.next;
        }
        return dummy.next;
    }
}
