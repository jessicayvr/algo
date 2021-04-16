package problems.integer;

import java.util.*;

public class threeSums {

    private static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< arr.length-2; i++) {

            int left = i+1;
            int right = arr.length-1;

            while (left<right) {
                int i1 = arr[i] + arr[left] + arr[right];
                if (i1 == 0) {
                    result.add(Arrays.asList(arr[i], arr[left],arr[right]));
                    break;
                }
                if (i1 > 0 ) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists1 = threeSum(arr);
        System.out.println(lists1);
    }
}
