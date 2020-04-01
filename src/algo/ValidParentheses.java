package algo;

import java.util.Stack;

public class ValidParentheses {

    // Time:  O(n)
    // Space: O(n)
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty() || !isMatch(stack.peek(), c)) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(char left, char right) {
            switch (left) {
                case '{':
                    return right == '}';
                case '[':
                    return right == ']';
                case '(':
                    return right == ')';
                default:
                    return false;
            }
        }

        // 这个方法很巧妙
        public boolean isValid2(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

        AlgoHelper.println(new Solution().isValid("{[]}") + "");
    }
}
