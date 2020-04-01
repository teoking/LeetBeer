package algo;

public class FindMinimumInRotatedSortedArray {
    static class Solution {
        public int findMin(int[] nums) {
            return findMin(nums, 0, nums.length - 1);
        }

        private int findMin(int[] nums, int l, int r) {
            if (l + 1 >= r) {
                return Math.min(nums[l], nums[r]);
            }
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = l + (r - l) / 2;
            return Math.min(findMin(nums, l, mid - 1),
                    findMin(nums, mid, r));
        }
    }
}
