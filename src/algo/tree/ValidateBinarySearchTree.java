package algo.tree;

// LeetCode 98
public class ValidateBinarySearchTree {
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
    // Runtime: O(n)
    // Space: O(h) h is height of the tree.
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    // Memory Usage: 38.9 MB, less than 84.91% of Java online submissions for Validate Binary Search Tree.
    // 检查边界是否满足：左子树节点值小于父亲和父亲的父亲..., 右子树节点值大于父亲和父亲的父亲...
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }

        boolean isValid(TreeNode root, double min, double max) {
            if (root == null) {
                return true;
            }

            if (root.val <= min || root.val >= max) {
                return false;
            }

            boolean isLeftValid = isValid(root.left, min, root.val);
            boolean isRightValid = isValid(root.right, root.val, max);
            return isLeftValid && isRightValid;
        }
    }
}
