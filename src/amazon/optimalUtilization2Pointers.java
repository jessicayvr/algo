package amazon;

import java.util.*;

public class optimalUtilization2Pointers {
    /**
     * SORTING EXAMPLE These are the same
     */
    private void sortingExample() {
        int[][] aa = {{1, 5}, {2, 1}, {3, 2}, {4, 3}};
        int[][] ab = {{1, 5}, {2, 1}, {3, 2}, {4, 3}};
        Arrays.sort(aa, Comparator.comparingInt((int[] curr) -> curr[1]));
        Arrays.sort(ab, (int[] x, int[]y) -> x[1] < y[1]? -1 : 1);
    }

    /**
     *  Each element is a pair of integers where the 1st integer represents the unique id and the 2nd integer represents a value.
     *  Find an element from a and an element form b such that the sum of their values is less or equal
     *  to target and as close to target as possible.
     */
    public static void main(String[] args) {
//        int[][] a = {{1, 2}, {2, 4}, {3, 6}};
//        int[][] b = {{1, 2}};
//        int target = 7;

        int[] arr = new int[] { 6, 8, 7, 4, 312, 78, 54, 9, 12, 100, 89, 74 };
        int[] sort = sort(arr);
        int [][] a = {{1, 0}, {2, 0}, {3, 0}};
        int[][] b = {{1, 0}};
        int target = 7;
        List<List<Integer>> lists = doOptimal(a, b, target);
        System.out.println(lists);
    }

    private static List<List<Integer>> doOptimal(int[][] a, int[][] b, int target) {
        Arrays.sort(a, Comparator.comparingInt((int[] curr) -> curr[1]));
        Arrays.sort(b, Comparator.comparingInt((int[] curr) -> curr[1]));

        int left = 0;
        int right = b.length-1;
        List<List<Integer>> result = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        while (left < a.length && right >= 0) {
            int[] a_pair = a[left];
            int[] b_pair = b[right];
            int cur = target - (a_pair[1] + b_pair[1]);
            if (diff == cur) {
                result.add(new ArrayList<>(Arrays.asList(a[left][0], b[right][0])));
            }
            if (diff > cur && cur >= 0) {
                result = new ArrayList<>();
                result.add(new ArrayList<>(Arrays.asList(a[left][0], b[right][0])));
                diff = cur;
            }

            if (target > a_pair[1] + b_pair[1]) {
                left++;
            } else {
                right--;
            }
        }

        return result;

    }
    public static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
