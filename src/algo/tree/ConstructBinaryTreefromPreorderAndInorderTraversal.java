package algo.tree;

import java.util.HashMap;

// LC 105: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

/*

        build([3, (9), (20, 15, 7)], [(9), 3, (15, 20, 7)])
        root=3
        /                           \
       /                             \
build([9], [9])                  build([20, (15, 7)], [(15), 20, (7)])
root=9                           root=20
                                  /                         \
                                 /                           \
                            build([15], [15])               build([7], [7])
                            root=15                         root=15
*/
    // Runtime: 3 ms, faster than 67.96% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    // Memory Usage: 40.2 MB, less than 10.29% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    static class RecursiveSolution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, 0, 0, preorder.length);
        }

        TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int len) {
            if (len <= 0) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            if (len == 1) return root;
            int k = inStart;
            while (root.val != inorder[k]) {
                k++;
            }
            int n = k - inStart;
            root.left = build(preorder, inorder, preStart + 1, inStart, n);
            root.right = build(preorder, inorder, preStart + n + 1, k + 1, len - n - 1);
            return root;
        }
    }

    // Runtime: 3 ms, faster than 67.96% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    // Memory Usage: 42.8 MB, less than 5.08% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    static class RecursiveHashMapOptSolution {

        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>(preorder.length * 2);
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, 0, preorder.length);
        }

        TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int len) {
            if (len <= 0) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            if (len == 1) return root;
            int k = map.get(root.val);
            int n = k - inStart;
            root.left = build(preorder, inorder, preStart + 1, inStart, n);
            root.right = build(preorder, inorder, preStart + n + 1, k + 1, len - n - 1);
            return root;
        }
    }
}
