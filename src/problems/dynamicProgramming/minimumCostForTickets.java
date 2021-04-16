package problems.dynamicProgramming;

import java.util.Arrays;

// O(N) n is the number of days (not just travel days)
public class minimumCostForTickets {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int i = mincostTickets(days, costs);
        System.out.print(i);
    }

    private static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] travelDay = new boolean[lastDay+1];
        for (int day: days) {
            travelDay[day] = true;
        }
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            if (!travelDay[i]) {
                dp[i] = dp[i-1];
                continue;
            }

            // the min or the cost travelled from 0 to yesterday + todays cost
            dp[i] = Math.min(dp[i], dp[i-1] + costs[0]);

            if (i -7 >= 0) {
                // cost at 7 days ago (because your paying for them now) + cost for today
                dp[i] = Math.min(dp[i], dp[i-7] + costs[1]);
            } else {
                // you can still choose to pay for the last 7 days even if it didn't exists
                dp[i] = Math.min(dp[i], costs[1]);
            }

            if (i -30 >=0) {
                // covers all your travel the last 30 days
                dp[i] = Math.min(dp[i], dp[i-30] + costs[2]);
            } else {
                // you can still choose to pay for the last 30 days even if it didn't exists
                dp[i] = Math.min(dp[i], costs[2]);
            }

        }
        return dp[lastDay];
    }
}
