import java.util.ArrayList;
import java.util.List;

public class LC143_reorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        if (cur == null) return;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            if (i == j) {
                list.get(i).next = null;
                break;
            } else if (i == j - 1) {
                list.get(i).next = list.get(j);
                list.get(j).next = null;
                break;
            } else {
                list.get(i).next = list.get(j);
                list.get(j).next = list.get(i + 1);
            }
        }
    }
}