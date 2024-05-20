import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC147_insertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        LC147_insertionSortList test = new LC147_insertionSortList();
        ListNode listNode = test.insertionSortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    // 链表转换为数组，排序，再重新构建链表
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode cur = head.next;
        List<ListNode> list = new LinkedList<>();
        list.add(head);
        while (cur != null) {
           list.add(cur);
           cur = cur.next;
        }
        list.sort((a, b) -> a.val - b.val);
        dummy.next = list.get(0);
        list.get(list.size() - 1).next = null;
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return dummy.next;
    }
   // 在原链表上操作
    public ListNode insertionSortList01(ListNode head) {
        // 边界情况：如果列表为空或只有一个元素，那么它已经是排序的。
        if (head == null || head.next == null) return head;

        // 创建一个虚拟节点以简化边缘情况，例如在头部插入。
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // lastSorted节点标记已排序部分的列表的结束。
        ListNode lastSorted = head;
        // 要插入到排序部分的当前节点。
        ListNode curr = head.next;

        while (curr != null) {
            // 如果当前节点已经大于最后排序的节点，
            // 它在正确的位置，我们将lastSorted指针向前移动。
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                // 否则，我们需要找到插入当前节点的正确位置。
                ListNode prev = dummy;
                // 找到插入点（节点值大于当前节点的节点）。
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // 将当前节点插入到其正确位置。
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            // 移动到要排序的下一个节点。
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}
