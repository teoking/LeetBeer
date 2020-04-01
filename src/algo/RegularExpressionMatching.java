package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algo.RegularExpressionMatching.Solution.Pattern.*;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "abcdefg";
        String p = "a*c.e*";
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        AlgoHelper.println("%s matches %s = %b", s, p, solution2.isMatch(s, p));
        AlgoHelper.println("%s matches %s = %b", "aa", "a", solution2.isMatch("aa", "a"));
        AlgoHelper.println("%s matches %s = %b", "aa", "a*", solution2.isMatch("aa", "a*"));
        AlgoHelper.println("%s matches %s = %b", "aab", "c*a*b", solution2.isMatch("aab", "c*a*b"));
        AlgoHelper.println("%s matches %s = %b", "mississippi", "mis*is*p*.", solution2.isMatch("mississippi", "mis*is*p*."));
        AlgoHelper.println("%s matches %s = %b", "mississippi", "mis*is*ip*.", solution2.isMatch("mississippi", "mis*is*ip*."));

//        testPattern(p);
//
//        try {
//            testPattern("mis*is*p*.");
//        } catch (IllegalArgumentException e) {
//            print(e.getLocalizedMessage());
//        }
//
//        testPattern(".*");
//        testPattern("a*");
//        testPattern("a");
    }

    private static void testPattern(String p) {
        List<Solution.Pattern> patterns = Solution.Pattern.compile(p);
        for (Solution.Pattern pt : patterns) {
            AlgoHelper.println(pt.toString());
        }
    }

    // LOL: 对题意理解错了。。。
    static class Solution {
        // Patterns:
        // .* :  通配，只要出现，一定匹配
        // a* :  a开头，至下一个字母截止；位于尾部时，直接匹配
        // .  :  匹配一个字符
        // ab :  需要按字母逐一匹配

        // Steps:
        // 1. 找到patterns（两种思路：至少找两个，当前和下一个；或者两两全部找到）
        // 2. 按pattern逐一匹配input

        public boolean isMatch(String s, String p) {
            try {
                List<Solution.Pattern> patterns = Solution.Pattern.compile(p);
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length;) {
                    for (Pattern pt : patterns) {
                        switch (pt.type) {
                            case TYPE_ALL:
                                return true;
                            case TYPE_LETTER_SUB:
                                if (chars[i] == pt.start[0]) {
                                    // 首字符匹配即可
                                    if (pt.end == 0) {
                                        return true;
                                    } else {
                                        for (int j = ++i; j < chars.length; j++) {
                                            if (chars[j] == pt.end) {
                                                break;
                                            } else {
                                                i++;
                                            }
                                        }
                                    }
                                }
                                break;
                            case TYPE_ONLY_ONE:
                                i++;
                                break;
                            case TYPE_SUB_STR:
                                for (int j = 0; j < pt.start.length; j++) {
                                    if (pt.start[j] != chars[i]) {
                                        return false;
                                    } else {
                                        i++;
                                    }
                                }
                                break;
                            default:
                                return false;
                        }
                    }

                    // pattern匹配完了，但是字符还没匹配完
                    if (i != chars.length) {
                        return false;
                    }
                }
            } catch (IllegalArgumentException e) {
                return false;
            }

            return true;
        }

        static class Pattern {
            // .* : no start, end
            static final int TYPE_ALL = 0;
            // a* : [start, end) or [start, ...)
            static final int TYPE_LETTER_SUB = 1;
            // .  : no start, end
            static final int TYPE_ONLY_ONE = 2;
            // ab : start, no end
            static final int TYPE_SUB_STR = 3;
            // *. : wrong pattern
            static final int TYPE_WRONG_PATTERN = 4;

            int type;
            char[] start;
            char end = 0;

            @Override
            public String toString() {
                return "Pattern{" +
                        "type=" + type +
                        ", start=" + Arrays.toString(start) +
                        ", end=" + end +
                        '}';
            }

            static List<Pattern> compile(String p) throws IllegalArgumentException {
                char[] pArr = p.toCharArray();
                List<Pattern> patternList = new ArrayList<>();
                Pattern pattern;
                for (int i = 0; i < pArr.length;) {
                    pattern = new Pattern();
                    char c = pArr[i];
                    if (c == '.') {
                        if (i + 1 < pArr.length) {
                            char next = pArr[++i];
                            if (next == '*') {
                                pattern.type = TYPE_ALL;
                                i = pArr.length;
                            } else {
                                pattern.type = TYPE_ONLY_ONE;
                            }
                        } else {
                            pattern.type = TYPE_ONLY_ONE;
                        }
                    } else {
                        if (i + 1 < pArr.length) {
                            char next = pArr[i + 1];
                            if (next == '*') {
                                i++;
                                char next2 = i + 1 < pArr.length ? pArr[i + 1] : 0;
                                if (96 < next2 && next2 < 123) {
                                    pattern.type = TYPE_LETTER_SUB;
                                    pattern.start = new char[]{c};
                                    pattern.end = next2;
                                    i++;
                                } else {
                                    pattern.type = TYPE_LETTER_SUB;
                                    pattern.start = new char[]{c};
                                    i++;
                                }
                            } else {
                                boolean isEnd = false;
                                for (int j = i + 1; j < pArr.length; j++) {
                                    if (pArr[j] == '.') {
                                        pattern.type = TYPE_SUB_STR;
                                        char[] arr = new char[j - i];
                                        System.arraycopy(pArr, i, arr, 0, arr.length);
                                        pattern.start = arr;
                                        isEnd = true;
                                        i = j;
                                        break;
                                    } else if (pArr[j] == '*') {
                                        pattern.type = TYPE_SUB_STR;
                                        char[] arr = new char[j - 1 - i];
                                        System.arraycopy(pArr, i, arr, 0, arr.length);
                                        pattern.start = arr;
                                        isEnd = true;
                                        i = j - 1;
                                        break;
                                    } else {
                                        // continue
                                    }
                                }
                                if (!isEnd) {
                                    pattern.type = TYPE_SUB_STR;
                                    char[] arr = new char[pArr.length - i + 1];
                                    System.arraycopy(pArr, i, arr, 0, arr.length);
                                    pattern.start = arr;
                                    i = pArr.length - 1;
                                }
                            }
                        } else {
                            pattern.type = TYPE_SUB_STR;
                            pattern.start = new char[] {c};
                            i++;
                        }
                    }

                    patternList.add(pattern);
                }
                return patternList;
            }
        }
    }

    // Recursion
    static class Solution2 {
        public boolean isMatch(String text, String pattern) {
            if (pattern.isEmpty()) return text.isEmpty();

            boolean first_match = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

            if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
                return (isMatch(text, pattern.substring(2)) ||
                        (first_match && isMatch(text.substring(1), pattern)));
            } else {
                return first_match && isMatch(text.substring(1), pattern.substring(1));
            }
        }
    }
}
