package amazon;

import java.util.*;

/**
 * O(N)
 */
public class mostCommonWord {

    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        String p = "a, a, a, a, b,b,b,c, c";
        String[] ban = new String[]{"a"};
        String str = findMaxWordNotBanned(ban, p);
        System.out.println(str);
    }

    private static String findMaxWordNotBanned(String[] banned, String paragraph) {
        String p = paragraph.replaceAll("\\p{Punct}", "").toLowerCase();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] ps = p.split(" ");
        int max = 0;
        String res = "";
        Map<String, Integer> map = new HashMap<>();
        for (String s: ps) {
            if (!set.contains(s)) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);

                }
                if (map.get(s) > max) {
                    max = map.get(s);
                    res = s;
                }
            }
        }
        return res;
    }
}
