package algo;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    // 一个非常快的解法
    // Time   : O(log(n))
    // Space  : O(1)
    // Runtime: 2ms
    static int lengthOfLongestSubstring(String input) {
        if(input.length() <= 1) {
            return input.length();
        }
        char[] inputChars = input.toCharArray();
        int result = 0;
        int startIndex = 0;
        int size = inputChars.length;
        for(int i = 1; i < size; i++) {
            char c = inputChars[i];
            for(int j = startIndex; j < i; j++) {
                if(inputChars[j] == c) {
                    int max = i - startIndex;
                    if(max > result)
                        result = max;
                    startIndex = j + 1;
                    break;
                }
            }
        }
        int len = input.length() - startIndex;
        return Math.max(len, result);
    }

    // My original solution
    // Time   : O(n*n)
    // Space  : O(n)
    // Runtime: 71ms
    public int lengthOfLongestSubstringMy(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < chars.length;) {
            char c = chars[i];
            if (map.containsKey(c)) {
                i = map.get(c) + 1;
                maxLen = Math.max(maxLen, len);
                // O(n) opt
                map.clear();
                len = 0;
            } else {
                map.put(c, i);

                len++;
                i++;
            }
        }

        return Math.max(maxLen, len);
    }

    static String longestSubstring(String input) {
        if(input.length() <= 1) {
            return input;
        }
        char[] inputChars = input.toCharArray();
        int result = 0;
        int startIndex = 0;
        int start = 0;
        int end = 0;
        int size = inputChars.length;
        for(int i = 1; i < size; i++) {
            char c = inputChars[i];
            for(int j = startIndex; j < i; j++) {
                if(inputChars[j] == c) {
                    int max = i - startIndex;
                    if(max > result) {
                        result = max;
                        start = startIndex;
                        end = start + max;
                    }
                    startIndex = j + 1;
                    break;
                }
            }
        }
        int len = input.length() - startIndex;
        if (len > result) {
            start = startIndex;
            end = start + len;
        }
        return input.substring(start, end);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        print(s, lengthOfLongestSubstring(s), longestSubstring(s));

        s = "pwwkew";
        print(s, lengthOfLongestSubstring(s), longestSubstring(s));
    }

    private static void print(String s, int maxLenOf, String maxSubStr) {
        System.out.println(s + ": maxSubStrLen=" + maxLenOf + ", maxSubStr=" + maxSubStr);
    }
}
