public class LC002_addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        LC002_addTwoNumbers lc = new LC002_addTwoNumbers();
        ListNode l3 = lc.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = l1;
        while (l1 != null && l2 != null) {
            l1.val += l2.val + carry;
            // 不要写if来判断l1的值是不是大于10再来算进位，没必要
            // 不大于10   carry = l1.val / 10; 此时 carry = 0;
            carry = l1.val / 10;
            l1.val %= 10;
            // 有一个为空 说明一个链表已经到最后一个节点了
            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
            } else {
                break;
            }
        }
        // 循环出来 l1.next == null 或 l2.next == null 或都为 null
        // 此时应该重点考虑都为null的情况
        if (l2.next != null) {
            l1.next = l2.next;
        }
        // 处理 都为 null 的情况 拼接过后l1.next == null  说明该节点为最后一个节点
        if (l1.next == null && carry > 0) {
            ListNode node = new ListNode(carry);
            l1.next = node;
            return l3;
        } else {
            l1 = l1.next;
            while (l1 != null) {
                l1.val += carry;
                // 不要写if来判断l1的值是不是大于10再来算进位，没必要
                // 不大于10   carry = l1.val / 10; 此时 carry = 0;
                carry = l1.val / 10;
                l1.val %= 10;
                if (l1.next != null)
                    l1 = l1.next;
                else
                    break;
            }
            if (carry > 0) {
                ListNode node = new ListNode(carry);
                l1.next = node;
            }
            return l3;
        }
    }
}
