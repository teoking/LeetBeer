package algo;

public class SearchInRotatedSortedArray {
    // Runtime: O(log n)
    // Space:   O(1)
    static class Solution {
        public int search(int[] nums, int target) {
            //1.找到最小值p
            //2.
            //2.以p切分nums: left, right
            //3.return if target<leftMin binarySearch(right)
            //  else binarySearch(left part)
            if (nums.length == 0) {
                return -1;
            }

            // Sorted
            if (nums[0] < nums[nums.length - 1]) {
                return binarySearch(nums, 0, nums.length - 1, target);
            }

            // 非sorted，先找到p，依据target和p的大小觉得遍历哪部分
            int p = findMin(nums, 0, nums.length - 1);
            int l = binarySearch(nums, 0, p - 1, target);
            int r = binarySearch(nums, p, nums.length - 1, target);
            return Math.max(l, r);
        }

        private int findMin(int[] nums, int start, int end) {
            // 只有1个或2个元素
            if (start + 1 >= end) {
                if (nums[start] > nums[end]) {
                    return end;
                } else {
                    return start;
                }
            }

            // Sorted
            if (nums[start] < nums[end]) {
                return start;
            }

            int mid = start + (end - start) / 2;
            int l = findMin(nums, start, mid - 1);
            int r = findMin(nums, mid, end);
            if (nums[l] < nums[r]) {
                return l;
            } else {
                return r;
            }
        }

        private int binarySearch(int[] nums, int start, int end, int target) {
            while (start <= end) {
                int m = start + (end - start) / 2;
                if (nums[m] == target) {
                    return m;
                } else if (nums[m] < target) {
                    start = m + 1;
                } else {
                    end = m - 1;
                }
            }
            return -1;
        }
    }
}
