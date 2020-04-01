package algo;

public class RemoveNthNodeFromEndOfList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode start = new ListNode(0);
            start.next = head;
            ListNode slow = start, fast = start;

            //Move fast in front so that the gap between slow and fast becomes n
            for (int i = 1; i <= n + 1; i++) {
                fast = fast.next;
            }
            //Move fast to the end, maintaining the gap
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //Skip the desired node
            slow.next = slow.next.next;
            return start.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new Solution().removeNthFromEnd(head, 1);

        head.next = new ListNode(2);
        new Solution().removeNthFromEnd(head, 1);

        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution().removeNthFromEnd(head, 1);
    }
}
