package algo.tree

import algo.AlgoHelper
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertFalse

class SymmetricTreeTest {

    @Test
    fun test() {
        val treeStr = "[1,2,2,3,4,4,3]"
        val tree = AlgoHelper.stringToTreeNode(treeStr)
        val treeStr2 = "[1,2,2,null,3,null,3]"
        val tree2 = AlgoHelper.stringToTreeNode(treeStr2)

        val recursiveSolution = SymmetricTree.RecursiveSolution()
        assertTrue(recursiveSolution.isSymmetric(tree))
        assertFalse(recursiveSolution.isSymmetric(tree2))

        val iteratorSolution = SymmetricTree.IteratorSolution()
        assertTrue(iteratorSolution.isSymmetric(tree))
        assertFalse(iteratorSolution.isSymmetric(tree2))
    }
}