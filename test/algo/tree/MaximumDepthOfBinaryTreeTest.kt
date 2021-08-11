package algo.tree

import algo.AlgoHelper
import org.junit.Test
import kotlin.test.assertEquals

class MaximumDepthOfBinaryTreeTest {

    @Test
    fun testFastestSolution() {
        val treeStr = "[1,null,2,3, 4, null, 5, null, null, 6]";
        val treeNode = AlgoHelper.stringToTreeNode(treeStr)
        val solution = MaximumDepthOfBinaryTree.FastestSolution()
        val solutionAnswer = solution.maxDepth(treeNode)
        val expected = 5

        assertEquals(expected, solutionAnswer)
    }

    @Test
    fun testRecursiveSolution() {
        val treeStr = "[1,null,2,3, 4, null, 5, null, null, 6]";
        val treeNode = AlgoHelper.stringToTreeNode(treeStr)
        val solution = MaximumDepthOfBinaryTree.RecursiveSolution()
        val solutionAnswer = solution.maxDepth(treeNode)
        val expected = 5

        assertEquals(expected, solutionAnswer)
    }

    @Test
    fun testLevelTraversalSolution() {
        val treeStr = "[1,null,2,3, 4, null, 5, null, null, 6]";
        val treeNode = AlgoHelper.stringToTreeNode(treeStr)
        val solution = MaximumDepthOfBinaryTree.LevelTraversalSolution()
        val solutionAnswer = solution.maxDepth(treeNode)
        val expected = 5

        assertEquals(expected, solutionAnswer)
    }

}