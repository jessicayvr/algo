package problems.dynamicProgramming;

import java.util.Arrays;

public class knapSac {

    private static int doKnap(int[] val, int[] wt, int w) {

        int[][] dp = new int[val.length + 1][w+1];

        // i is the length of the vals
        for (int i = 0; i < dp.length; i++) {

            // 0....to max Weight
            for (int j = 0; j <= w; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;

                    // check if first weight is less than max size j
                    // equ. if max size j - first weight wt[i-1] is greater than equal to 0
                } else if (wt[i-1] <= j) {
                    // either add items and item -1 and j-wt or do not add item and weight so item -1 and weight stays the same
                   dp[i][j] = Math.max(dp[i-1][j-wt[i-1]] + val[i-1], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][w];

    }

    public static int doAgain(int[] val, int[] wt, int w) {
        int[] dp = new int[w+1];
        Arrays.fill(dp, -1);
       return doAgainUtil(val, wt, w, dp);
    }

    private static int doAgainUtil(int[] val, int[] wt, int curW, int[] dp) {
        if (dp[curW] > -1) {
            return dp[curW];
        }
        int max = 0;
        for (int i = 0; i < val.length; i++) {
            if (wt[i] <= curW) {
              int temp = val[i] + doAgainUtil(val, wt, curW-wt[i], dp);
              if (temp > max) {
                  max = temp;
              }
            }
        }
        dp[curW] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] wt = {1,2,3};
        int w = 5;

        int j = doKnap(val, wt,w);
        int k = doAgain(val, wt, w);
        System.out.println(j);
        System.out.println(k);
    }



}
