package amazon;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Given container and a list of package size. Container must have at least 30 space. Return index of the two largest packages.
 */
public class truckPackage {
    public static void main(String[] arg) {
        int container = 30;
        int[] arr = {1, 10, 25, 35, 60};
        int[] arr1 = {20, 50, 40, 25, 30, 10};
        int[] arr2 = {};
        int[] arr3 = {0,0,40,1};

        List<Integer> largest = findLargest(container, arr3);

        System.out.println(largest);
    }

    /*
     * returns index of the array, CANNOT SORT
     */
    private static List<Integer> findLargest(int container, int[] arr) {
        int target = container - 30;
        if (target < 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> l = new ArrayList<>();

        int max = Integer.MIN_VALUE;;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                for (int j = i + 1; j < arr.length; j++) {
                    int cur = arr[i] + arr[j];
                    if (cur == target && Math.max(arr[i], arr[j]) > max) {
                        max = Math.max(arr[i], arr[j]);
                        l = new ArrayList<>(Arrays.asList(i, j));
                    }
                }
            }
        }

        return l;
    }
}
