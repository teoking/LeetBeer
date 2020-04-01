package algo

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertTrue

class GroupAnagramsTest {

    val strs1 = arrayOf("", "b", "")
    val expected1 = arrayOf(
            arrayOf("b"),
            arrayOf("", "")
    )

    val strs2 = arrayOf("ant","ant")
    val expected2 = arrayOf(
            arrayOf("ant","ant")
    )

    @Test
    fun test() {
        val s = GroupAnagrams.Solution()

        val res1 = s.groupAnagrams(strs1)
        assertTrue(assertThis(expected1, res1))

        val res2 = s.groupAnagrams(strs2)
        assertTrue(assertThis(expected2, res2))
    }

    @Test
    fun testSolution2() {
        val s = GroupAnagrams.Solution2()

        val res1 = s.groupAnagrams(strs1)
        assertTrue(assertThis(expected1, res1))

        val res2 = s.groupAnagrams(strs2)
        assertTrue(assertThis(expected2, res2))
    }

    private fun assertThis(expected1: Array<Array<String>>, res1: List<MutableList<String>>): Boolean {
        for (array in expected1) {
            var isFound = false
            for (list in res1) {
                if ((array contentEquals list.toTypedArray())) {
                    isFound = true
                    break;
                }
            }
            if (!isFound) {
                return false
            }
        }
        return true
    }

}