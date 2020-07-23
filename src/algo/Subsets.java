package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// LC 78
public class Subsets {

    int[] nums;
    List<List<Integer>> answer;

    List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        this.nums = nums;
        Stack<Integer> cur = new Stack<>();

        // 求c(0, 0), c(1, 0), ..., c(n, 0)，其和就是最终结果
        for (int i = 0; i <= nums.length; ++i) {
            dfs(3,0, cur);
        }

        return answer;
    }

    /**
     * 求从start开始，取n个元素的组合数
     * @param n 需要取多少个元素
     * @param start 当前取值的起始位置
     * @param cur 当前取值数组
     */
    private void dfs(int n, int start, Stack<Integer> cur) {
        // 当前取值数组大小等于需要取元素的个数
        if (cur.size() == n) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; ++i) {
            cur.push(nums[i]);
            dfs(n, i + 1, cur);
            cur.pop();
        }
    }
}
