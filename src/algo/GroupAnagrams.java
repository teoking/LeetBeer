package algo;

import java.util.*;

public class GroupAnagrams {
    /*
     * 下面的解法会通不过一些特殊case，如["ant","ant"]
     * Input: ["ant","ant"]
     * Output: [["ant"]]
     * Expected: [["ant","ant"]]
     */
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();

            if (strs == null || strs.length == 0) return ans;

            boolean[] added = new boolean[strs.length];
            for (int i = 0; i < strs.length; i++) {
                if (!added[i]) {
                    List<String> res = new ArrayList<>();
                    String str1 = strs[i];
                    res.add(str1);
                    added[i] = true;

                    //空字符和单字符，相等时即为anagram
                    if (str1.length() <= 1) {
                        for (int j = i + 1; j < strs.length; j++) {
                            String str2 = strs[j];
                            if (str2.equals(str1)) {
                                res.add(str2);
                                added[j] = true;
                            }
                        }
                    } else {
                        // Build map
                        HashMap<Character, Integer> map = new HashMap<>(str1.length());
                        HashMap<String, Integer> mapStr = new HashMap<>();
                        for (char c : str1.toCharArray()) {
                            map.put(c, 0);
                        }
                        mapStr.put(str1, 0);

                        for (int j = i + 1; j < strs.length; j++) {
                            if (!added[j]) {
                                boolean isAnagram = true;
                                String str2 = strs[j];
                                for (char c2 : str2.toCharArray()) {
                                    if (!map.containsKey(c2)) {
                                        isAnagram = false;
                                        break;
                                    }
                                }
                                if (isAnagram) {
                                    if (!mapStr.containsKey(str2)) {
                                        res.add(str2);
                                        mapStr.put(str2, 0);
                                    }
                                    added[j] = true;
                                }
                            }
                        }
                    }
                    ans.add(res);
                }
            }
            return ans;
        }
    }

    /*
    Maintain a map ans : {String -> List} where each key K is a sorted string,
    and each value is the list of strings from the initial input that when sorted, are equal to K.
    就是说关键在于比较anagram排序后的结果
     */
    static class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();

            Map<String, List> ans = new HashMap<String, List>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
}
