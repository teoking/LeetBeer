package algo;

/**
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 参见：https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
 */
public class RotateImage {
    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * [1,2,3]               [7,8,9]              [7,4,1]
     * [4,5,6]  -上下翻转->   [4,5,6]  -对角调换->  [8,5,2]
     * [7,8,9]               [1,2,3]              [9,6,3]
     */
    static class Solution {
        public void rotate(int[][] matrix) {
            //reverse up and down
            int up = 0, down = matrix.length - 1;
            while (up < down) {
                int[] temp = matrix[up];
                matrix[up] = matrix[down];
                matrix[down] = temp;
                up++;
                down--;
            }

            //swap the symmetry
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        /*
         * anticlockwise rotate
         * first reverse left to right, then swap the symmetry
         * 1 2 3     3 2 1     3 6 9
         * 4 5 6  => 6 5 4  => 2 5 8
         * 7 8 9     9 8 7     1 4 7
         */
        public void antiRotate(int[][] matrix) {
            //reverse left to right
            for (int[] m : matrix) {
                int temp = m[0];
                m[0] = m[m.length - 1];
                m[m.length - 1] = temp;
            }

            //swap the symmetry
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

}
