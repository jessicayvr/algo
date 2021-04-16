package problems.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class longestSubStringWithoutRepeatingCharacters {

    private static int longest(String str) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < str.length()) {
            if (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            } else {
                set.add(str.charAt(right));
                right++;
                max = Math.max(right - left, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int longest = longest("abcabcbb");
        System.out.println("longest substring without repeating characters: " + longest);
    }
}
