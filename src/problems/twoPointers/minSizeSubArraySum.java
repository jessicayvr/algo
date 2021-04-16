package problems.twoPointers;

public class minSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int cur = 0;
        while (left < nums.length && right < nums.length) {
            cur = cur + nums[right];
            right++;
            while (cur >= s) {
                min = Math.min(min, right-left);
                cur = cur - nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
