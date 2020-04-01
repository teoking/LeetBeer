package algo

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class RotateImageTest {

    @Test
    fun testRotate() {
        val s = RotateImage.Solution()
        val matrix = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
                intArrayOf(7, 4, 1),
                intArrayOf(8, 5, 2),
                intArrayOf(9, 6, 3)
        )

        s.rotate(matrix)
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testAntiRotate() {
        val s = RotateImage.Solution()
        val matrix = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
                intArrayOf(3, 6, 9),
                intArrayOf(2, 5, 8),
                intArrayOf(1, 4, 7)
        )
        s.antiRotate(matrix)
        assertArrayEquals(expected, matrix)
    }
}