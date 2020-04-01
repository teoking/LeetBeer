package algo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class JumpGameTest {

    @Test
    fun canJump() {
        val s = JumpGame.Solution()
        val nums = intArrayOf(2, 3, 1, 1, 4)
        assertTrue(s.canJump(nums))

        val num2 = intArrayOf(3, 2, 1, 0, 4)
        assertFalse(s.canJump(num2))

        val num3 = intArrayOf(3)
        assertTrue(s.canJump(num3))

        val num4 = intArrayOf(0)
        assertTrue(s.canJump(num4))

        val num5 = intArrayOf(1, 1, 2, 0, 1, 0)
        assertTrue(s.canJump(num5))
    }

    @Test
    fun canJumpStressTest() {
        val nums = IntArray(88901)
        var x = 25000
        var y = 0
        while (x > 0) {
            nums[y++] = x--
        }
        val s = JumpGame.Solution2()
        assertFalse(s.canJump(nums))
    }

}