package problems.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetII {

    public static void main(String[] args) {
        int[] num = new int[] {1,2,2};
        System.out.print(doSubsetII(num));
    }

    private static List<List<Integer>> doSubsetII(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        doSubsetIIBT(result, num, new ArrayList<>(), 0);
        return result;
    }

    private static void doSubsetIIBT(List<List<Integer>> result, int[] num, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i-1]) {
                continue;
            }
            temp.add(num[i]);
            doSubsetIIBT(result, num, temp, i + 1);
            temp.remove(temp.size()-1);
        }

    }
}
