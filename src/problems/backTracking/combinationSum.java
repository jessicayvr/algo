package problems.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  N!​ / (N−k)! k!
 * for example given N = 4, k = 2
 * given 2 spots and 4 numbers
 * _ _
 * first dash - any one of the 4 numbers so, 4chances
 * second dash - any of the 3remaining numbers so, 3chances
 *              ( one number already chosen for first dash )
 * 4*3 = 12 = (4*3*2*1)/(2*1) = N!/(N-K)!
 * but there are repetitions in this way (1,2) and (2,1) are counted.
 * (Eliminate repetitions of k numbers)
 */
public class combinationSum {

    public static void main(String[] args) {
        int[] candidates =  {2,3,6,7};
        int target = 7;

        System.out.print(combinationSum(candidates, target));

    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backTracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking(result, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse
            tempList.remove(tempList.size() - 1);
        }
    }
}
