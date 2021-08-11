package algo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ReverseListTest {

    @Test
    fun test() {
        val solution = ReverseList.Solution()
        val head = ListNode(1)
        val node1 = ListNode(2)
        val node2 = ListNode(3)
        val node3 = ListNode(4)

        head.next = node1
        node1.next = node2
        node2.next = node3

        var h = solution.reverse(head)
        while (h.next != null) {
            print("$h,")
            h = h.next;
        }
    }

}