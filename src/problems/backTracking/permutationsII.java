package problems.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsII {
    // not distinct numbers;
    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 3};
        System.out.print(doPerm(num));
    }

    private static List<List<Integer>> doPerm(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num); // not necessary
        boolean[] visited = new boolean[num.length];
        permBacktracking(result, num, new ArrayList<Integer>(), visited);
        return result;
    }

    private static void permBacktracking(List<List<Integer>> result, int[] num, ArrayList<Integer> integers, boolean[] visited) {
        if (integers.size() == num.length) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            // avoid adding self
            if (visited[i]) {
                continue;
            }

            // second full iteration when i=1, but all visited is false (only need to check previous)
            if (i > 0 && !visited[i-1] && num[i] == num[i-1]) {
                continue;
            }
            visited[i] = true;
            integers.add(num[i]);
            permBacktracking(result, num, integers, visited);
            integers.remove(integers.size() - 1);
            visited[i] = false;
        }
    }
}
