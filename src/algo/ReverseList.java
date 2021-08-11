package algo;

public class ReverseList {

    static class Solution {

        ListNode reverse(ListNode head) {
            if (head == null) {
                return null;
            }

            // root相当一个哨兵，root.next其实就是head
            ListNode root = new ListNode(-1);
            // cur从head开始
            ListNode cur = head;
            while (cur != null) {
                // 保存下一个要交换的节点
                ListNode next = cur.next;

                // 当前节点的next指向head，此时实际上有两个链表
                cur.next = root.next;
                // head更新为当前节点
                root.next = cur;

                // 当前节点后移到next
                cur = next;
            }
            // root.next是真正的head
            return root.next;
        }
    }
}
