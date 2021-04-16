package problems.stringArrays;

import java.util.HashSet;
import java.util.Set;

public class wordBreak {

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("w");
        dictionary.add("or");
        dictionary.add("rd");
        dictionary.add("break");
        dictionary.add("wo");
        dictionary.add("problem");

        String str = "wordbreakproblem";

        boolean isWordBreak = doWordBreak(str, dictionary);
        boolean isWordBreakk = wordBreak1(str, dictionary);
        System.out.println(isWordBreak + "  " + isWordBreakk);

    }
    //O(2^n)
    private static boolean doWordBreak(String str, Set<String> dictionary) {
        if (str.length() == 0) {
            return true;
        }

        for (int i = 1; i <= str.length(); i++) {
            String substring = str.substring(0, i);
            if (dictionary.contains(substring) && doWordBreak(str.substring(i), dictionary)) {
                return true;
            }
        }
        return false;
    }

    // O(n^2)
    public static boolean wordBreak1(String s, Set<String> dict) {
        // create the memoization array to save results and avoid repeat computations
        Boolean[] canBreak = new Boolean[s.length()];
        // convert the list into set for faster lookup
        Set<String> wordSet = new HashSet<>(dict);
        // recursion with memoization
        return helper(s, 0, wordSet, canBreak);
    }

    public static boolean helper(String s, int startIdx, Set<String> wordSet, Boolean[] memo) {
        // in case we've reached the end of string, return true
        if (startIdx == s.length()) {
            return true;
        }
        // else if we've already computed on current substring before
        if (memo[startIdx] != null) {
            return memo[startIdx]; // auto-unboxing
        }

        boolean res = false;
        // iterate through all indices after startIdx, explore every possible word
        for (int i = startIdx + 1; i <= s.length(); i++) {
            String currWord = s.substring(startIdx, i);
            // skip if this is not a word in the input dictionary
            if (!wordSet.contains(currWord)) {
                continue;
            }
            // recursively call upon the rest of string
            if (helper(s, i, wordSet, memo)) {
                res = true;
                break;
            }
        }
        // add result to memo and return the result
        memo[startIdx] = res;
        return res;
    }
}
