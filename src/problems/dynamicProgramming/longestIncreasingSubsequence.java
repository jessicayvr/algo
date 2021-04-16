package problems.dynamicProgramming;

// O(n^2)
public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] num = new int[] {10,9,2,5,3,7,101,18};
        System.out.print(doLongestIncreasingSubsequence(num));
    }

    private static int doLongestIncreasingSubsequence(int[] num) {
        int[] dp = new int[num.length];

        int max = 0;
        for (int i = 0; i < num.length; i++) {
            // for itself
            int len = 1;

            // traverse from 0 to i-1
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
