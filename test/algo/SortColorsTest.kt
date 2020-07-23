package algo

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SortColorsTest {

    @Test
    fun test() {
        val solution = SortColors()
        val nums1 = intArrayOf(2, 0, 2, 1, 1, 0)
        val expect1 = intArrayOf(0, 0, 1, 1, 2, 2)

        assertArrayEquals(expect1, nums1.apply {
            solution.sortColors(this)
        })

        val nums2 = intArrayOf()
        val expect2 = intArrayOf()

        assertArrayEquals(expect2, nums2.apply {
            solution.sortColors(this)
        })

        val nums3 = intArrayOf(2, 0, 1)
        val expect3 = intArrayOf(0, 1, 2)

        assertArrayEquals(expect3, nums3.apply {
            solution.sortColors(this)
        })

        val nums4 = intArrayOf(2, 1, 0)
        val expect4 = intArrayOf(0, 1, 2)

        assertArrayEquals(expect4, nums4.apply {
            solution.sortColors(this)
        })

        val nums5 = intArrayOf(1, 0, 2)
        val expect5 = intArrayOf(0, 1, 2)

        assertArrayEquals(expect5, nums5.apply {
            solution.sortColors(this)
        })

        assertArrayEquals(
                intArrayOf(1, 1, 2),
                intArrayOf(1, 1, 2).apply {
                    solution.sortColors(this)
                })

        assertArrayEquals(
                intArrayOf(0, 1, 1),
                intArrayOf(1, 1, 0).apply {
                    solution.sortColors(this)
                })

        assertArrayEquals(
                intArrayOf(0, 0, 1),
                intArrayOf(0, 1, 0).apply {
                    solution.sortColors(this)
                })
    }

}