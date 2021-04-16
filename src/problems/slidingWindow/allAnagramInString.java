package problems.slidingWindow;

import java.util.*;

public class allAnagramInString {
    public static void main(String[] args) {
        String s2 = "eidbaooo";
        String s1 = "ab";
        System.out.print(findAnagrams(s1, s2));
    }

    public static boolean findAnagrams(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i< s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int count = map.size();

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            if (map.containsKey(s2.charAt(right))) {
                int x = map.get(s2.charAt(right));
                x--;
                if (x == 0) {
                    count--;
                }
                map.put(s2.charAt(right), x);
            }
            right++;

            while (count == 0) {
                if (map.containsKey(s2.charAt(left))) {
                    int x = map.get(s2.charAt(left));
                    x++;
                    if (x == 1) {
                        count++;
                    }
                    map.put(s2.charAt(left), x);
                }

                if (right-left == s1.length()) {
                    return true;
                }
                left++;
            }
        }
        return false;
    }
}
