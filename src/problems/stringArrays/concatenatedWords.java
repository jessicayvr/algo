package problems.stringArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class concatenatedWords {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        // {"catsdogcats","dogcatsdog","ratcatdogcat"}

        findAllConcatenatedWordsInADict(words);
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> dict = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            dict.add(words[i-1]);
            if (wordBreak(words[i], dict)) {
                result.add(words[i]);
            }
        }

        return result;
    }

    public static boolean wordBreak(String word, List<String> dict) {
        Boolean[] dp = new Boolean[word.length()];
        return doWordBreak(dp, word, dict, 0);
    }

    private static boolean doWordBreak(Boolean[] dp, String word, List<String> dict, int startIdx) {
        if (word.length() == startIdx) {
            return true;
        }
        if (dp[startIdx] != null) {
            return dp[startIdx];
        }

        boolean res = false;
        for (int i = startIdx + 1; i <= word.length(); i++) {
            if (dict.contains(word.substring(startIdx, i))) {
                if (doWordBreak(dp, word, dict, i)) {
                    res = true;
                    break;
                }
            }
        }
        dp[startIdx] = res;
        return res;
    }
}
