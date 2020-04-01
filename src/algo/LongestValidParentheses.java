package algo;

import java.util.Stack;

public class LongestValidParentheses {
    //https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
    //Time: O(n)
    //Space: O(n)
    static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (!stack.empty()) {
                        max = Math.max(max, i - stack.peek());
                    } else {
                        stack.push(i);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        new Solution().longestValidParentheses("(()))()");
    }
}
