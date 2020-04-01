package algo;

/**
 * leetcode link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 4, 8};
        int[] nums2 = new int[] {2, 3, 5, 6};
//        System.out.println(findMedianSortedArrays(nums1, nums2));

        System.out.println(new Solution2().findMedianSortedArrays(nums1, nums2));
    }

    // 这个解法有个问题，如果数组相同时就会死循环
    static class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            // binary search on the short array.
            if (n1 > n2) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int k = (n1 + n2 + 1) / 2;
            int l = 0;
            int r = n1;
            while (l < r) {
                int m1 = l + (r - 1) / 2;
                int m2 = k - m1;
                if (nums1[m1] < nums2[m2 - 1])
                    l = m1 + 1;
                else
                    r = m1;
            }

            int m1 = l;
            int m2 = k - l;
            int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                    m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

            if ((n1 + n2) % 2 == 1)
                return c1;

            int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                    m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

            return (c1 + c2) * 0.5;
        }
    }

    // 这个解法更通用
    // 这个算法关键在于理解B[j - 1] <= A[i] && A[i - 1] <= B[j]
    // 即：找到i，使得A中左半部分最大值大于B右半部分最小值，且A中有半部分最小值大于B左半部分最大值
    // 找到i后，再处理边界情况
    static class Solution2 {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }
}
