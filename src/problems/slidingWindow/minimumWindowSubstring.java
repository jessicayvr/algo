package problems.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.print(s1);
    }
    private static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0 ; i < t.length(); i++) {
            int i1 = map.getOrDefault(t.charAt(i), 0) + 1;
            map.put(t.charAt(i), i1);
        }

        int count = map.size();
        int right = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int cur = 0;
        String x= null;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                Integer integer = map.get(s.charAt(right));
                integer--;
                map.put(s.charAt(right), integer);
                if (integer == 0) {
                    count--;
                }
            }

            right++;

            while (count == 0) {
                cur = right-left;
                if (cur < min) {
                    x = s.substring(left,right);
                    min = cur;
                }
                if (map.containsKey(s.charAt(left))) {
                    Integer integer = map.get(s.charAt(left));
                    integer++;
                    map.put(s.charAt(left), integer);
                    if (integer == 1) {
                        count++;
                    }
                }
                left++;
            }
        }
        return x;
    }
}
