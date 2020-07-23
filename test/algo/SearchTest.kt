package algo

import org.junit.Assert.assertEquals
import org.junit.Test

class SearchTest {

    private val search = Search()

    @Test
    fun testBinarySearch() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        fun search(nums: IntArray, target: Int): Int = search.binarySearch(nums, target, 0, nums.size)

        assertEquals(0, search(nums, 1))
        assertEquals(5, search(nums, 6))
        assertEquals(1, search(nums, 2))
        assertEquals(-1, search(nums, 7))
        assertEquals(-1, search(nums, 0))
    }

}