package problems.integer;

import java.util.HashSet;
import java.util.Set;

public class KdiffPairsArray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));
    }
    private static int findPairs(int[] nums, int k) {
        Set<Integer> used = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int abs = Math.abs(nums[i] - k);
            if (visited.contains(abs) && !used.contains(nums[i])) {
                used.add(abs);
                used.add(nums[i]);
                ans++;
            } else {
                visited.add(nums[i]);
            }
        }
        return ans;
    }
}
