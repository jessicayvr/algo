package problems.twoPointers;

import java.util.Arrays;

public class sums3Closest {

    public static void main(String[] args) {
        int[] nums = {1,5,7,9,13};
        int target = 16;

        int res = findSumOfClosest(nums, target);
        System.out.println(res);
    }

    private static int findSumOfClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resClosest = Integer.MAX_VALUE;
        int resSum = 0;
        for (int i = 0; i < nums.length -2 ; i++ ) {
            int left = i+ 1;
            int right = nums.length -1;

            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                int closest = Math.abs(target - curSum);

                if (closest < resClosest) {
                    resClosest = closest;
                    resSum = curSum;
                }

                if (curSum == target) {
                    return target;
                }
                if (curSum > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return resSum;
    }
}
