package algo

import org.junit.Assert.assertEquals
import org.junit.Test

class FindMinimumInRotatedSortedArrayTest {
    @Test
    fun testFindMin() {
        val s = FindMinimumInRotatedSortedArray.Solution()
        assertEquals(0, s.findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
        assertEquals(1, s.findMin(intArrayOf(3, 4, 5, 1, 2)))
    }
}