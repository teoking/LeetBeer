package algo.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /*
    Runtime: 7 ms, faster than 6.43% of Java online submissions for Binary Tree Level Order Traversal.
    Memory Usage: 40.8 MB, less than 5.44% of Java online submissions for Binary Tree Level Order Traversal.
     */
    static class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();
            if (root == null) {
                return answer;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (queue.size() != 0) {
                List<Integer> levelAnswer = new ArrayList<>();
                List<TreeNode> levelNode = new ArrayList<>();
                for (TreeNode node : queue) {
                    levelAnswer.add(node.val);
                    if (node.left != null) {
                        levelNode.add(node.left);
                    }
                    if (node.right != null) {
                        levelNode.add(node.right);
                    }
                }
                queue.clear();
                queue.addAll(levelNode);
                answer.add(levelAnswer);
            }
            return answer;
        }
    }

    /*
    Runtime: 2 ms, faster than 16.72% of Java online submissions for Binary Tree Level Order Traversal.
    Memory Usage: 40.7 MB, less than 8.69% of Java online submissions for Binary Tree Level Order Traversal.
     */
    static class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();
            if (root == null) {
                return answer;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
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
            return answer;
        }
    }

    /*
    Runtime: 1 ms, faster than 60.85% of Java online submissions for Binary Tree Level Order Traversal.
    Memory Usage: 40.7 MB, less than 7.08% of Java online submissions for Binary Tree Level Order Traversal.
     */
    static class Solution3 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();
            if (root == null) {
                return answer;
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
            return answer;
        }
    }
}
