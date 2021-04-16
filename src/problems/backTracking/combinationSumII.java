package problems.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
    public static void main(String[] args) {
        /*
        Input: candidates = [10,1,2,7,6,1,5], target = 8,
        A solution set is:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]
         */

        int[] num = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.print(doCombII(num, target));
    }

    private static List<List<Integer>> doCombII(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(num, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backTrack(int[] num, int remain, List<List<Integer>> result, List<Integer> tempList, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < num.length; i++) {

            // ex.
            // 1, 1, 2, 5
            // start = 0, i = 3, oh hit the end doesn't equal our target
            // start = 0, i = 1, backTrack start = 2. But since num[i] == num[i-1] we this whole loop will get the same result
            if (i > start && num[i] == num[i - 1]) {
                continue; // skip duplicates
            }
            tempList.add(num[i]);
            backTrack(num, remain - num[i],result, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

}
