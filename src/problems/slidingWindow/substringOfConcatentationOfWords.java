package problems.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ????? leetcode 30
public class substringOfConcatentationOfWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        findSubstring(s, words);
    }
    private static List<Integer> findSubstring(String s, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int wordsLength = 0;
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                int i1 = map.getOrDefault(word.charAt(i), 0) + 1;
                map.put(word.charAt(i), i1);
            }
            wordsLength = wordsLength + word.length();
        }

        int count = map.size();

        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))){
                Integer integer = map.get(s.charAt(right));
                integer--;
                map.put(s.charAt(right), integer);
                if (integer == 0) {
                    count--;
                }
            }
            right++;

            while (count == 0) {
                if (map.containsKey(s.charAt(left))) {
                    Integer integer = map.get(s.charAt(left));
                    integer++;
                    map.put(s.charAt(left), integer);
                    if (integer == 1) {
                        count++;
                    }
                }

                if (right - left == wordsLength) {

                    for (int k = 0; k < words.length; k++) {

                    }

                }

            }
        }
        return result;
    }
}
