package amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * O(N)
 */
public class twoSumUniquePair {

    public static void main(String[] args) {
        /**
         * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
         * Output: 2
         * Explanation:
         * 1 + 46 = 47
         * 2 + 45 = 47
         */

        int[] nums = {1, 1, 2, 45, 46, 46};
        int target = 47;

        int n = twoSum(nums, target);
        System.out.println(n);
    }

    private static int twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (set.contains(comp) && !used.contains(nums[i])) {
                count++;
                used.add(comp);
                used.add(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return count;
    }
}
