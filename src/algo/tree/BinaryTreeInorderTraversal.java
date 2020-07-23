package algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// LC 94: https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {

    // 递归解法
    // Runtime: O(n)
    // Space: O(n)
    static class RecursionSolution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            traverse(root, ans);
            return ans;
        }

        void traverse(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            traverse(root.left, ans);
            ans.add(root.val);
            traverse(root.right, ans);
        }
    }

    // 循环遍历解法
    // Runtime: O(n)
    // Space: O(n)
    static class IteratorSolution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                // left node进栈
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                // Visit node
                cur = stack.pop();
                ans.add(cur.val);

                // iterate right node
                cur = cur.right;
            }
            return ans;
        }
    }
}
