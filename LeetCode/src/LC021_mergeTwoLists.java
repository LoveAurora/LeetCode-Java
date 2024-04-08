import java.util.Objects;

public class LC021_mergeTwoLists {
    public static void main(String[] args) {

    }

    // 空间换时间
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1) && Objects.isNull(list2))
            return null;
        if (Objects.isNull(list1))
            return list2;
        if (Objects.isNull(list2))
            return list1;
        ListNode head = new ListNode();
        ListNode temp = head;

        while (!Objects.isNull(list1) && !Objects.isNull(list2)) {
            if (list1.val < list2.val) {
                ListNode newNode = new ListNode();
                newNode = list1;
                list1 = list1.next;
                temp.next = newNode;
                temp = temp.next;
            } else {
                ListNode newNode = new ListNode();
                newNode = list2;
                list2 = list2.next;
                temp.next = newNode;
                temp = temp.next;
            }
        }
        if (Objects.isNull(list1)) {
            temp.next = list1;
        }
        if (Objects.isNull(list2)) {
            temp.next = list2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1) && Objects.isNull(list2))
            return null;
        if (Objects.isNull(list1))
            return list2;
        if (Objects.isNull(list2))
            return list1;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2= list2.next ;
            }
            temp = temp.next;

        }
        if (Objects.isNull(list1)) {
            temp.next = list1;
        }
        if (Objects.isNull(list2)) {
            temp.next = list2;
        }


        return dummy.next;
    }


}
