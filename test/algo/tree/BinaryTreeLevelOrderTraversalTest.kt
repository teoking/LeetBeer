package algo.tree

import algo.AlgoHelper
import algo.WordSearch
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BinaryTreeLevelOrderTraversalTest {

    @Test
    fun test() {
        val treeStr = "[1,null,2,3, 4, null, 5, null, null, 6]";
        val treeNode = AlgoHelper.stringToTreeNode(treeStr)
        val expected = "[[1], [2], [3, 4], [5], [6]]"

        val solution = BinaryTreeLevelOrderTraversal.Solution3()
        val ans = solution.levelOrder(treeNode)
    }

}