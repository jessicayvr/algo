package problems.stringArrays;

import java.util.*;

public class topKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = topKFrequent(words, k);
        System.out.print(strings);
    }
    private static List<String> topKFrequent(String[] words, int k) {
       Map<String, Integer> map = new HashMap<>();
       for (int i = 0; i < words.length; i++) {
           Integer count = map.getOrDefault(words[i], 0) + 1;
           map.put(words[i], count);
       }

       PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((cur, ex) -> {
           if (cur.getValue().equals(ex.getValue())) {
               return cur.getKey().compareTo(ex.getKey());
           }
           if (cur.getValue() < ex.getValue()) {
               return 1;
           } else {
               return -1;
           }
       });

       pq.addAll(map.entrySet());
       List<String> result = new ArrayList<>();
       for (int i = 0; i < k; i++) {
           result.add(pq.poll().getKey());
       }

       return result;

    }
}
