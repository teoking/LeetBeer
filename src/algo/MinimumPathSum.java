package algo;

// LC 64. Minimum Path Sum
public class MinimumPathSum {

    // Recursion with memoization (计划递归)
    // Runtime: O(mn)
    // Space: O(mn)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int[][] table = new int[m][n];
        return walk(grid, table, n, m, m - 1, n - 1);
    }

    int walk(int[][] grid, int[][] table, int n, int m, int x, int y) {
        // 起点
        if (x == 0 && y == 0) {
            return grid[x][y];
        }

        // 边界
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }

        // 已经找过的最小路径
        if (table[x][y] > 0) {
            return table[x][y];
        }

        // 当前位置最小path sum算法
        // f(x, y) = grid[x][y] + min(f(x + 1, y) + f(x, y + 1))
        table[x][y] = grid[x][y] + Math.min(walk(grid, table, n, m, x - 1, y),
                walk(grid, table, n, m, x, y - 1));

        return table[x][y];
    }

    // DP
    // Runtime: O(mn)
    // Space: O(1)
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 从(0, 0)开始
                if (i == 0 && j == 0) continue;
                // 处于第一列时，f(x, y) = f(x, y - 1) + f(x, y)
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                // 处于第一行, f(x, y) = f(x - 1, y) + f(x, y)
                else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                // 普遍情况, f(x, y) = f(x, y) + min(f(x - 1, y), f(x, y - 1))
                else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        // 最终返回目标点值
        return grid[m - 1][n - 1];
    }
}
