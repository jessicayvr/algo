package problems.matrix;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * O(MN) Dynamic programming
 */
public class maxOfMinAltitudes_DP {

    public static void main(String[] args) {
        /**
         * Input:
         * [[5, 1],
         *  [4, 5]]
         *
         * Output: 4
         * Explanation:
         * Possible paths:
         * 5 → 1 → 5 => min value is 1
         * 5 → 4 → 5 => min value is 4
         * Return the max value among minimum values => max(4, 1) = 4.
         *
         * Don't include the first or final entry. You can only move either down or right at any point in time.
         */

        int[][] m = new int[][]{{5, 1},
                {4, 5}};

        int[][] mm = new int[][] {{1, 2, 3},
                {4, 5, 1}};

        int maxOfMin = maxMin(mm);
        System.out.println(maxOfMin);

    }

    public static int maxMin(int[][] m) {

        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = Integer.MAX_VALUE;
        dp[m.length - 1][m[0].length - 1] = Integer.MAX_VALUE;

        // do first row, find min comparing with dp left
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], m[i][0]);
        }

        // do first col, find min comparing with dp up
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], m[0][i]);
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {

                // if bottom right hand cell, then find MAX
                if (i == m.length - 1 && j == m[0].length - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    // find min comparing dp above
                    int minFirst = Math.min(dp[i - 1][j], m[i][j]);

                    // find min comparing dp left
                    int minSecond = Math.min(dp[i][j - 1], m[i][j]);

                    // set max min (as if i,j is final cell)
                    dp[i][j] = Math.max(minFirst, minSecond);
                }
            }
        }

        return dp[m.length - 1][m[0].length - 1];
    }
}
