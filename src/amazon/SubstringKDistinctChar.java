package amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * O(n^2) can be O(N) need to revisit. Similiar to Longest Substring with At Most K Distinct Characters leetcode340
 */
public class SubstringKDistinctChar {

    public static void main(String[] args) {
        /**
         * Input: str = "pqpqs", k = 2
         * Output: 7
         * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
         */

        String s = "eceba";
        int x = 3;

        String str = "pqpqs";
        int k = 2;

        int n = doDistinctK(str, k);
        System.out.println(n);
    }

    private static int doDistinctK(String str, int k) {

        Set<Character> set;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            set = new HashSet<>();
            set.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                set.add(str.charAt(j));
                if (set.size() == k) {
                    count++;
                }
                if (set.size() > k) {
                    break;
                }
            }
        }
        return count;
    }
}
