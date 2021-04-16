package problems.slidingWindow;

public class maximumSubArray {

    public static void main(String[] args) {
        int[] num = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(num);
        System.out.print(i);
    }

    private static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (nums[i] > sum) {
                sum = nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
