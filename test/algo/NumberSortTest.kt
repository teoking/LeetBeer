package algo

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class NumberSortTest {

    @Test
    fun test() {
        val solution = NumberSort()

        assertArrayEquals(
                intArrayOf(-23, -2, -88, -3, -4, 2, 8, 7, 12, 5, 10, 35),
                intArrayOf(10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35).apply {
                    solution.sort(this)
                })

        assertArrayEquals(
                intArrayOf(1, 2, 3),
                intArrayOf(1, 2, 3).apply {
                    solution.sort(this)
                })

        assertArrayEquals(
                intArrayOf(-1, -2, -3),
                intArrayOf(-1, -2, -3).apply {
                    solution.sort(this)
                })

        assertArrayEquals(
                intArrayOf(-1, -2, 1),
                intArrayOf(-1, 1, -2).apply {
                    solution.sort(this)
                })

        assertArrayEquals(
                intArrayOf(-1, 1, 2),
                intArrayOf(1, -1, 2).apply {
                    solution.sort(this)
                })
    }

}