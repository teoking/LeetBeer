package algo;

import java.util.Arrays;

// LC55
public class JumpGame {
    // 这个方法太慢了
    // Runtime: O(2^n)
    // Space: O(n)  -- 递归栈
    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            if (nums.length == 1) {
                return true;
            }
            return jump(nums, 0, nums[0]);
        }

        private boolean jump(int[] nums, int start, int maxStep) {
            // 可以跳到终点
            if (start + maxStep >= nums.length - 1) {
                return true;
            }

            for (int i = start + maxStep; i > start; i--) {
                if (jump(nums, i, nums[i])) {
                    return true;
                }
            }
            // 不能跳到终点
            return false;
        }
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    static class Solution2 {

        public boolean canJump(int[] nums) {
            Index[] memo = new Index[nums.length];
            Arrays.fill(memo, Index.UNKNOWN);

            memo[memo.length - 1] = Index.GOOD;

            for (int i = nums.length - 2; i >= 0; i--) {
                int furthestJump = Math.min(i + nums[i], nums.length - 1);
                for (int j = i + 1; j <= furthestJump; j++) {
                    if (memo[j] == Index.GOOD) {
                        memo[i] = Index.GOOD;
                        break;
                    }
                }
            }

            return memo[0] == Index.GOOD;
        }
    }
}
