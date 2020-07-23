package algo;

// 有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变，要求时间复杂度为O(n), 空间复杂度为O(1)。
// 例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35} 变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}
public class NumberSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = 0, j = nums.length - 1;
        // i == j时，则交换完成
        while (i < j) {
            // 如果正数在左，负数在右
            if (nums[i] > 0 && nums[j] < 0) {
                swap(nums, i, j);
            }
            // i指针碰到负数向后移动
            if (nums[i] < 0) {
                i++;
            }
            // j指针碰到正数向前移动
            if (nums[j] > 0) {
                j--;
            }
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
