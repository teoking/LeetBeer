package algo;

import java.util.*;

// LC 692
public class TopKFrequentWords {
    static class Word {
        String word;
        int freq;

        Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "{" +
                    "w='" + word + '\'' +
                    ",f=" + freq +
                    '}';
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        //通过map统计字数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        //构造最小堆，比较器：先频率，再字母序
        PriorityQueue<Word> queue = new PriorityQueue<>(
                (w1, w2) -> w1.freq != w2.freq
                        ? w1.freq - w2.freq
                        : compareWord(w1.word, w2.word)
        );

        //建堆，移除超过k的元素
        for (String w : map.keySet()) {
            queue.offer(new Word(w, map.get(w)));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        //从后往前取结果
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(0, queue.poll().word);
        }
        return ans;
    }

    int compareWord(String w1, String w2) {
        int minLen = Math.min(w1.length(), w2.length());
        int r = 0;
        for (int i = 0; i < minLen; i++) {
            r = w2.charAt(i) - w1.charAt(i);
            if (r != 0) {
                break;
            }
        }
        if (r == 0) {
            return w2.length() - w1.length();
        }
        return r;
    }
}
