package algo;

public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // Two pointer，三个区间:
        // nums[0...zero] nums(zero...two) nums[two...length-1]
        int zero = -1; // nums[0...zero] 全是0的区间
        int two = nums.length; // nums[two...length-1] 全是2的区间
        int i = 0;
        while (i < two) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else { // nums[i] == 0
                zero++;
                swap(nums, i, zero);
                // i交换至0区间最后一位，因此i指向下一位置
                i++;
            }
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
