package problems.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations {
    // distinct numbers;
    public static void main(String[] args) {
        int[] num = new int[] {1,2,3};
        System.out.print(doPerm(num));
    }

    private static List<List<Integer>> doPerm(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num); // not necessary
        permBacktracking(result, num, new ArrayList<Integer>());
        return result;
    }

    private static void permBacktracking(List<List<Integer>> result, int[] num, ArrayList<Integer> integers) {
        if (integers.size() == num.length) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (integers.contains(num[i])) {
                continue;
            }
            integers.add(num[i]);
            permBacktracking(result, num, integers);
            integers.remove(integers.size() -1);
        }
    }
}
