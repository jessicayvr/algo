package problems.dynamicProgramming;

import java.util.Arrays;

//O(coins.length * amount)
//O(amount)
public class minCoin {

    private static int doCoin(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // if amount is 11, min coins for coins {1} is 11. if dp[amount] is more than 11 that means no answer
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 6;
        // what is the least number of coins needed to make amount?
        int i = doCoin(coins, amount);
        System.out.println(i);
    }

}
