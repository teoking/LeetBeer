package algo;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {
    //二分找到最小和最大的index
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            if (nums == null || nums.length == 0) {
                return res;
            }

            res[0] = findFirst(nums, target);
            res[1] = findLast(nums, target);
            return res;
        }

        private int findFirst(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            if (nums[l] == target) return l;
            else if (nums[r] == target) return r;
            return -1;
        }

        private int findLast(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            if (nums[r] == target) return r;
            else if (nums[l] == target) return l;
            return -1;
        }
    }
}
