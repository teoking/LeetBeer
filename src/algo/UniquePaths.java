package algo;

// LC 62
// Runtime: O(mn^2)
// Space: O(mn)
public class UniquePaths {

    int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        return walk(table, m, n, 0, 0);
    }

    int walk(int[][] table, int m, int n, int x, int y) {
        // 如果x, y超出边界，则返回0，表示无可达路径
        if (x > m - 1 || y > n - 1) {
            return 0;
        }

        // 抵达目标点，返回1，表示找到一条路径
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        // 起点的path数为0，表示还没有抵达目标点，继续找
        // f(x, y) = f(x + 1, y) + f(x, y + 1)
        if (table[0][0] == 0) {
            table[x][y] = walk(table, m, n, x + 1, y) + walk(table, m, n, x, y + 1);
        }
        return table[x][y];
    }
}

// 从(0, 0)出发
// 找(0, 1)
//     找(0, 2)
//     找(1, 1)
// ...
// 找(1, 0)
//     找(1, 1)
//     找(2, 1)
// ...
