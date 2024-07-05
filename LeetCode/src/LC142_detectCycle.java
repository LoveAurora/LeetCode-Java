import java.util.HashMap;
import java.util.Map;

public class LC142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) return head;
            map.put(head, 1);
            head = head.next;
        }
        return null;
    }
}
