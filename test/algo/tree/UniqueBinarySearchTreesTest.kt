package algo.tree

import algo.tree.UniqueBinarySearchTrees
import org.junit.Assert.assertEquals
import org.junit.Test

class UniqueBinarySearchTreesTest {

    @Test
    fun test() {
        val solution = UniqueBinarySearchTrees.RecursiveSolution()
        assertEquals(5, solution.numTrees(3))
    }
}