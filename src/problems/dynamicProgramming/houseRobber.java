package problems.dynamicProgramming;

public class houseRobber {

    /**
     * Adjacent houses have security system connected.
     * Determine the maximum amount of money you can rob tonight without alerting the police
     */
    public static void main(String[] args) {
        int[] num = new int[] {1,2,3,1,4,7,2,0,1};
        int rob = rob(num);
        System.out.print(rob);
    }
    private static int rob(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length];

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length >= 2) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[length-1];
    }
}
