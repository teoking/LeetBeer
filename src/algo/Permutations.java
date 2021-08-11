package algo;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/permutations/
// Runtime: O(n*n!)指数级
// Space: O(n*n!)
// 回溯法: 一种通过探索所有可能的候选解来找出所有的解的算法。如果候选解被确认不是一个解（或者至少不是最后一个解），
// 回溯算法会通过在上一步进行一些变化抛弃该解，即回溯并且再次尝试。
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        //dfs
        pmute(nums, 0, nums.length, used, cur, ans);
        return ans;
    }

    private void pmute(int[] nums, int d, int n, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
        //1.已找到n个排列
        if (d == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //元素已访问过，则跳过
            if (used[i]) continue;
            used[i] = true;
            //已找到一个元素
            cur.add(nums[i]);
            //找下一个
            pmute(nums, d + 1, n, used, cur, ans);
            //清空状态，回归上一层
            cur.remove(cur.size() - 1);
            //清空元素访问状态
            used[i] = false;
        }
    }
}
