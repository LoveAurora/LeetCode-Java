import java.awt.*;

public class LC237_deleteNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        deleteNode(node);

    }

    public static void deleteNode(ListNode node) {
        ListNode cur; // 定义一个当前节点指针 cur
        int flag = 1; // 定义一个标志位 flag，初始值为 1
        cur = node; // 将 cur 指针指向传入的节点 node

        // flag 的作用是为了让 cur 节点的下一个节点指向 node 节点
        // 这样到最后一个节点就可以把 cur.next 赋值为 null 完成删除
        // 重点就是处理第一个节点
        while (node.next != null) { // 循环遍历链表，直到 node 的下一个节点为空（即 node 是最后一个节点）
            node.val = node.next.val; // 将 node 的值替换为其下一个节点的值
            node = node.next; // 将 node 指针向后移动到下一个节点
            if (flag == 1) { // 如果 flag 等于 1
                flag += 1; // 将 flag 加 1，表示已经处理了第一个节点
            } else { // 如果 flag 不等于 1
                cur = cur.next; // 将 cur 指针向后移动到下一个节点
            }
        }
        cur.next = null; // 将 cur 的下一个节点指针指向 null，完成删除操作
    }

}
