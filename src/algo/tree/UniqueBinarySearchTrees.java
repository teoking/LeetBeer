package algo.tree;

public class UniqueBinarySearchTrees {

    // 递归解法
    // Runtime: 2850 ms, faster than 5.02% of Java online submissions for Unique Binary Search Trees.
    // Memory Usage: 36.4 MB, less than 28.91% of Java online submissions for Unique Binary Search Trees.
    // f(n) = f(0) * f(n-1-0) + f(1) * f(n-1-1) + f(2) * f(n-1-2) + ...
    static class RecursiveSolution {
        public int numTrees(int n) {
            if (n <= 1) {
                return 1;
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += numTrees(i) * numTrees(n - 1 - i);
            }
            return ans;
        }
    }

    // 双循环解法
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
    // Memory Usage: 38.3 MB, less than 5.04% of Java online submissions for Unique Binary Search Trees.
    static class ForLoopSolution {
        public int numTrees(int n) {
            int[] a = new int[n + 1];
            a[0] = 1;
            a[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    a[i] += a[j] * a[i - j - 1];
                }
            }
            return a[n];
        }
    }
}
