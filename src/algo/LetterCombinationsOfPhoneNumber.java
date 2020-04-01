package algo;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    // Time: O(3^n * 4^m)
    // Space: O(3^n * 4^m)
    static class Solution {

        public List<String> letterCombinations(String digits) {
            // LinkedList is a Deque(double ended queue)
            LinkedList<String> ans = new LinkedList<String>();
            if (digits.isEmpty()) return ans;
            String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            for (int i = 0; i < digits.length(); i++) {
                // 这个等价于：int x = digits.charAt(i) - '0'
                int x = Character.getNumericValue(digits.charAt(i));
                // ans.peek().length() == i是关键的一个判断
                // len是结果长度，i是下标，二者相等时，表示结果是旧的，这时把当前串中的字符给加上
                while (ans.peek().length() == i) {
                    String t = ans.remove();
                    for (char s : mapping[x].toCharArray())
                        ans.add(t + s);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        AlgoHelper.println(new Solution().letterCombinations("234"));
    }
}
