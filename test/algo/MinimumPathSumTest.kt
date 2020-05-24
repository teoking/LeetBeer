package algo

import org.junit.Test
import kotlin.test.assertEquals

class MinimumPathSumTest {

    @Test
    fun test() {
        val solution = MinimumPathSum()

        assertEquals(7, arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1)
        ).run {
            solution.minPathSum(this)
        })

        assertEquals(5, arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1)
        ).run {
            solution.minPathSum(this)
        })

        assertEquals(6, arrayOf(
                intArrayOf(1, 2, 5),
                intArrayOf(3, 2, 1)
        ).run {
            solution.minPathSum(this)
        })

        assertEquals(4, arrayOf(
                intArrayOf(1),
                intArrayOf(1),
                intArrayOf(2)
        ).run {
            solution.minPathSum(this)
        })

        assertEquals(0, emptyArray<IntArray>().run {
            solution.minPathSum(this)
        })
    }

    @Test
    fun test2() {
        val solution = MinimumPathSum()

        assertEquals(7, arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1)
        ).run {
            solution.minPathSum2(this)
        })

        assertEquals(5, arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1)
        ).run {
            solution.minPathSum2(this)
        })

        assertEquals(6, arrayOf(
                intArrayOf(1, 2, 5),
                intArrayOf(3, 2, 1)
        ).run {
            solution.minPathSum2(this)
        })

        assertEquals(4, arrayOf(
                intArrayOf(1),
                intArrayOf(1),
                intArrayOf(2)
        ).run {
            solution.minPathSum2(this)
        })

        assertEquals(0, emptyArray<IntArray>().run {
            solution.minPathSum2(this)
        })
    }

}