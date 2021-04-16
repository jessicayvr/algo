package problems.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class longestSubstringWithKDistinctCharacter {

    public static void main(String[] args) {
        String x = "aaahhdbc";
        System.out.print(longestKDistinc(x, 2));
    }

    public static int longestKDistinc(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int mapSize = 0;
        int longest = 0;

        while (right < s.length()) {
            int count = map.getOrDefault(s.charAt(right), 0) + 1;
            map.put(s.charAt(right), count);
            if (count == 1) {
                mapSize++;
            }

            // keep doing this until map size is k again
            while (mapSize > k) {
                Integer integer = map.get(s.charAt(left));
                integer--;
                map.put(s.charAt(left), integer);
                if (integer <= 0) {
                    mapSize--;
                }

                longest = Math.max(right - left, longest);
                left++;
            }
            right++;
        }
        return longest;
    }
}
