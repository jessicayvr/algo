package problems.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * there are N numbers and 2 decision ( whether to include or leave a number )
 * [1,2,3]
 * [1(include/leave), 2(include/leave), 3(include/leave)]
 * 2*2*2 = 2^3
 * so 2^N
 */
public class subset {

    public static void main(String[] args) {
        int[] num = new int[] {1,2,3};
        List<List<Integer>> lists = doSubSetBT(num);
        System.out.println(lists);

    }

    private static List<List<Integer>> doSubSetBT(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        doSubset(num, result, new ArrayList<>(), 0);
        return result;
    }

    private static void doSubset(int[] num, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < num.length; i++) {
            temp.add(num[i]);
            doSubset(num, result, temp, i + 1);
            temp.remove(temp.size()-1);
        }
    }
}
