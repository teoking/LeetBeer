package algo

import org.junit.Assert.assertEquals
import org.junit.Test

class SearchInRotatedSortedArrayTest {

    @Test
    fun testSearch() {
        val s = SearchInRotatedSortedArray.Solution()
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        assertEquals(3, s.search(nums, 7))
        assertEquals(-1, s.search(nums, 3))
        assertEquals(4, s.search(nums, 0))
        assertEquals(0, s.search(nums, 4))

        val nums2 = intArrayOf()
        assertEquals(-1, s.search(nums2, 5))

        val nums3 = intArrayOf(1)
        assertEquals(-1, s.search(nums3, 2))
        assertEquals(0, s.search(nums3, 1))

        val nums4 = intArrayOf(1, 3)
        assertEquals(-1, s.search(nums4, 4))
        assertEquals(1, s.search(nums4, 3))
        assertEquals(-1, s.search(nums4, 0))

        val nums5 = intArrayOf(3, 5, 1)
        assertEquals(-1, s.search(nums5, 0))
        assertEquals(-1, s.search(nums5, 6))

        val nums6 = intArrayOf(1, 3, 5)
        assertEquals(-1, s.search(nums6, 0))
        assertEquals(0, s.search(nums6, 1))
        assertEquals(-1, s.search(nums6, 6))

        val nums7 = intArrayOf(5, 1, 3)
        assertEquals(2, s.search(nums7, 3))
        assertEquals(-1, s.search(nums7, 0))
        assertEquals(-1, s.search(nums7, 6))
    }
}