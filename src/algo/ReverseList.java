package algo;

public class ReverseList {

    static class Solution {

        ListNode reverse(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode root = new ListNode(-1);
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;

                cur.next = root.next;
                root.next = cur;

                cur = next;
            }
            return root.next;
        }
    }
}
