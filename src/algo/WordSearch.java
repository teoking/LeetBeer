package algo;

// LC 79: https://leetcode.com/problems/word-search/
public class WordSearch {

    char[][] board;
    int m;
    int n;
    String word;

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }

        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (search(i, j,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(int i, int j, int cur) {
        // 当前位置是否超出边界
        // 当前位置字符是否与搜索字符匹配
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(cur) != board[i][j]) {
            return false;
        }

        // 已经找到
        if (cur == word.length() - 1) {
            return true;
        }

        // 标记当前位置不可走
        char c = board[i][j];
        board[i][j] = 0;
        // 向当前位置相邻四个方向搜索，找到一个即可满足要求
        boolean found = search(i - 1, j, cur + 1)
                || search(i + 1, j, cur + 1)
                || search(i, j - 1, cur + 1)
                || search(i, j + 1, cur + 1);
        // 恢复当前位置可走
        board[i][j] = c;
        return found;
    }
}
