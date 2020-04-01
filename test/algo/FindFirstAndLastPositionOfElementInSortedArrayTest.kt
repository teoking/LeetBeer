package algo

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    fun testSearch() {
        val s = FindFirstAndLastPositionOfElementInSortedArray.Solution()
        val nums1 = intArrayOf(5, 7, 7, 8, 8, 10)
        assertArrayEquals(intArrayOf(3, 4), s.searchRange(nums1, 8))
        assertArrayEquals(intArrayOf(0, 0), s.searchRange(nums1, 5))
        val nums2 = intArrayOf(2, 2)
        assertArrayEquals(intArrayOf(0, 1), s.searchRange(nums2, 2))
    }
}