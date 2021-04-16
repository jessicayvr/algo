package problems.integer;

import java.util.HashSet;
import java.util.Set;

//O(n)
public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        findLongest(nums);
    }

    private static int findLongest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int curLength = 1;
            int curNum = nums[i];

            // find min number
            if (!set.contains(curNum - 1)) {
                // does set contain the next number? if yes keep going.
                while (set.contains(curNum + 1)) {
                    curLength++;
                    curNum++;
                }
            }
            res = Math.max(res, curLength);
        }
        return res;
    }

    private static boolean hasNext(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                return true;
            }
        }
        return false;
    }
}
