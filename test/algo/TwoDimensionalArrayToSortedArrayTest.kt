package algo

import org.junit.Test
import java.util.*
import kotlin.test.assertTrue

class TwoDimensionalArrayToSortedArrayTest {

    private val array = arrayOf(
            intArrayOf(1, 2, 0, -1, 5),
            null,
            intArrayOf(),
            intArrayOf(3, 1, 5, 0, 9)
    )

    private val expect = intArrayOf(
            -1, 0, 0, 1, 1, 2, 3, 5, 5, 9
    )

    @Test
    fun flatSort_bubble() {
        val solution = TwoDimensionalArrayToSortedArray()
        val result = solution.flatSort_bubbleSort(array)
        assertTrue {
            Arrays.compare(expect, result) == 0
        }
    }

    @Test
    fun flatSort_quickSort() {
        val solution = TwoDimensionalArrayToSortedArray()
        val result = solution.flatSort_quickSort(array)
        assertTrue {
            Arrays.compare(expect, result) == 0
        }
    }

}