package problems.integer;

import java.util.*;

public class mergeIntervals {
    public static void main(String[] args) {
        int[][] m = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(m);
        System.out.print(merge);

    }

    public static int[][] merge(int[][] intervals) {
      //  Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            // if result is empty or last end is smaller then next start
            if (result.isEmpty() || result.get(result.size()-1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // merge last with current;
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return  result.toArray(new int[result.size()][]);
    }
}
