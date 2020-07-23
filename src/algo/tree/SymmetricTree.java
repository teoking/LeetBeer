package algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    static class RecursiveSolution {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        boolean isMirror(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return t1.val == t2.val && isMirror(t1.left, t2.right)
                    && isMirror(t1.right, t2.left);
        }
    }

    static class IteratorSolution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(root);
            while (queue.size() > 0) {
                TreeNode t1 = queue.poll();
                TreeNode t2 = queue.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                queue.offer(t1.left);
                queue.offer(t2.right);
                queue.offer(t1.right);
                queue.offer(t2.left);
            }
            return true;
        }
    }
}
