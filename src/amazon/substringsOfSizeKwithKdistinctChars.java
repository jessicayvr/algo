package amazon;

import java.lang.reflect.Array;
import java.util.*;

public class substringsOfSizeKwithKdistinctChars {

    public static void main(String[] args) {
        /*
         * Given a string s and an int k,
         * return all unique substrings of s of size k with k distinct characters.
         */
        String s = "abcabcxabc";
        String str = "awaglknagawunagwkwagl";
        int k = 3;
        //Output: ["abc", "bca", "cab"]
        Set<String> subStrings = findSubStrings(s, 3);
        System.out.println(subStrings);
    }

    /**
     * LinkedHashSet preserves order of insertion
     */
    private static Set<String> findSubStrings(String str, int k) {
        Set<String> result = new LinkedHashSet<>();
        Set<Character> seen = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < str.length() && j < str.length()) {
          if (seen.contains(str.charAt(i))) {
              if (seen.size() == k) {
                  result.add(str.substring(j,i));
              }
              seen.remove(str.charAt(j));
              j++;
          } else {
              if (seen.size() == k) {
                  result.add(str.substring(j,i));
                  seen.remove(str.charAt(j));
                  j++;
              } else {
                  seen.add(str.charAt(i));
                  i++;
              }

          }
        }

        // do last one
        if (seen.size() == k) {
            result.add(str.substring(j,i));
        }

        return result;
    }
}
