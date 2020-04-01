package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    // DP思想
    // 通过map记录已遍历元素从而达到剪枝
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
            6, 2, 3, 0, 7, 4
        };

        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
