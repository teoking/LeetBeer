package algo.tree

import algo.AlgoHelper
import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryTreeInorderTraversalTest {

    @Test
    fun test() {
        val treeStr = "[1,null,2,3, 4, null, 5, null, null, 6]";
        val treeNode = AlgoHelper.stringToTreeNode(treeStr)
        val expected = "[1, 3, 6, 5, 2, 4]"

        val solution1 = BinaryTreeInorderTraversal.RecursionSolution()
        val ans = solution1.inorderTraversal(treeNode)
        val ansStr = AlgoHelper.integerArrayListToString(ans)
        assertEquals(expected, ansStr)

        val solution2 = BinaryTreeInorderTraversal.IteratorSolution();
        val ans2 = solution2.inorderTraversal(treeNode)
        val ansStr2 = AlgoHelper.integerArrayListToString(ans2);
        assertEquals(expected, ansStr2);
    }
}