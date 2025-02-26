package leetcode1;

import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {

            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = map.get(w1).compareTo(map.get(w2));
            if (freqCompare == 0) {
                return w2.compareTo(w1);

            }
            return freqCompare;
        });

        for (String s : map.keySet()) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {

    }
}
