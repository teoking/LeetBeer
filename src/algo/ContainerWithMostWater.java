package algo;

public class ContainerWithMostWater {

    // Brute-force
    // Runtime: O(n*n)
    // Space  : O(1)
    static class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int N = height.length;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int x = j - i;
                    int y = Math.min(height[i], height[j]);
                    int l = x * y;
                    if (l > max) {
                        max = l;
                    }
                }
            }
            return max;
        }
    }

    // Two pointer
    // Runtime: O(n)
    // Space  : O(1)
    static class Solution2 {
        public int maxArea(int[] height) {
            int max = 0;
            int N = height.length;
            for (int lo = 0, hi = N - 1; lo != hi;) {
                int iLo = height[lo];
                int iHi = height[hi];

                max = Math.max(max, Math.min(iLo, iHi) * (hi - lo));

                if (iLo > iHi) {
                    hi--;
                } else {
                    lo++;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] height = new int[]{1, 2, 1};
        AlgoHelper.println("" + s1.maxArea(height));

        Solution2 s2 = new Solution2();
        AlgoHelper.println("" + s2.maxArea(height));
    }
}
