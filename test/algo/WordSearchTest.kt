package algo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WordSearchTest {

    @Test
    fun test() {
        val solution = WordSearch()
        val board = arrayOf(
                charArrayOf('A','B','C','E'),
                charArrayOf('S','F','C','S'),
                charArrayOf('A','D','E','E')
        )
        assertTrue(solution.exist(board, "ABCCED"))
        assertTrue(solution.exist(board, "SEE"))
        assertFalse(solution.exist(board, "ABCD"))
        assertFalse(solution.exist(board, "ABAB"))
    }

}