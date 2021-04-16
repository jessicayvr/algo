package problems.stringArrays;

import java.util.*;

public class reorganizeString {

    public static void main(String[] args) {
        System.out.print(reorganizeString("aba"));
    }

    private static String reorganizeString(String str) {
        // create map with character and character count;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0) + 1;
            if (count > (str.length() + 1) / 2) {
                return "";
            }
            map.put(str.charAt(i), count);
        }

        // create pq sort ascending can do (a, b) -> b[1] - a[1]
        Comparator<int[]> comparator = Comparator.comparingInt(x -> x[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator.reversed());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // build string alternating
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            // string isn't empty and the previous character isn't the same
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                int character = first[0];
                sb.append((char) character);
                first[1]--;
                if (first[1] > 0) {
                    pq.add(new int[]{first[0], first[1]});
                }
            } else {
                int[] second = pq.poll();

                // wont happen already checked string is possible
                int character = second[0];
                sb.append((char) character);
                second[1]--;
                if (second[1] > 0) {
                    pq.add(new int[]{second[0], second[1]});
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}
