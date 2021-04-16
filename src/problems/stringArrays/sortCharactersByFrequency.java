package problems.stringArrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class sortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "Aabb";
        String s1 = frequencySort(s);
        System.out.print(s1);
    }
    private static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c: chars) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        Comparator<Map.Entry<Character, Integer>> comparator =  Comparator.comparingInt(Map.Entry::getValue);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(comparator.reversed());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> poll = pq.poll();
            for (int i = 0 ; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }
        return sb.toString();
    }

}
