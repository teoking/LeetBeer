package algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// LC 104: https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    // Runtime: 1 ms, faster than 17.47% of Java online submissions for Maximum Depth of Binary Tree.
    // Memory Usage: 40.7 MB, less than 5.05% of Java online submissions for Maximum Depth of Binary Tree.
    static class RecursiveSolution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // If is leaf, return depth 1
            if (root.left == null && root.right == null) {
                return 1;
            }

            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.right);
            // maxDepth = max(maxLeft, maxRight) + currentDepth (1)
            return Math.max(maxLeft, maxRight) + 1;
        }
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    // Memory Usage: 39.6 MB, less than 27.66% of Java online submissions for Maximum Depth of Binary Tree.
    static class FastestSolution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.right);
            // maxDepth = max(maxLeft, maxRight) + currentDepth (1)
            return Math.max(maxLeft, maxRight) + 1;
        }
    }

    // Level Order Traversal解法：在层级遍历是求出最大深度
    // Runtime: 1 ms, faster than 17.47% of Java online submissions for Maximum Depth of Binary Tree.
    // Memory Usage: 39.9 MB, less than 8.18% of Java online submissions for Maximum Depth of Binary Tree.
    static class LevelTraversalSolution {
        public int maxDepth(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (queue.size() != 0) {
                List<Integer> levelAnswer = new ArrayList<>();
                int qSize = queue.size();
                for (int i = 0; i < qSize; i++) {
                    TreeNode tempNode = queue.poll();
                    levelAnswer.add(tempNode.val);
                    if (tempNode.left != null) {
                        queue.offer(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        queue.offer(tempNode.right);
                    }
                }
                answer.add(levelAnswer);
            }
            return answer.size();
        }
    }
}
