package problems.dynamicProgramming;

//O(N)
public class houseRobberII {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,2};
        rob(nums);
    }

    public static int rob(int[] nums) {
        //Easily understandable base cases
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int withFirstHouse = houseRobber1(nums, 0, nums.length -2);
        int withLastHouse = houseRobber1(nums, 1, nums.length -1);
        return Math.max(withFirstHouse, withLastHouse);
    }

    public static int houseRobber1(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start+1]);

        for (int i = 2 + start; i <= end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[end];
    }
}
