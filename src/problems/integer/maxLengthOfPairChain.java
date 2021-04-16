package problems.integer;

import java.util.Arrays;
import java.util.Comparator;

// can always use dp @link longestIncreasingSubsequence
public class maxLengthOfPairChain {

    // using greedy, sort asc on second int.
    // check if cur < pair[0]
    // yes then cur = pair[1]
    // increase count;
    public static void main(String[] args) {
        int[][] pair = new int[][] {{1,2}, {3,6},{4,5},{6,7}};
        int longestChain = findLongestChain(pair);
        System.out.print(longestChain);
    }
    private static int findLongestChain(int[][] pairs) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Arrays.sort(pairs,c);
        int cur = 0;
        int i = 0;

        for (int i1 = 0; i1 < pairs.length; i1++) {
            int[] pair = pairs[i1];
            if (cur < pair[0]) {
                cur = pair[1];
                i++;
            }
        }
        return i;
    }
}
