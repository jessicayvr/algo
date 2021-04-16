package problems.integer;

import java.util.ArrayList;
import java.util.List;

public class findKClosestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        int k = 1;
        int x = 1;
        findClosestElements(arr, k, x);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = arr[0];
        int high = arr[arr.length - 1];
        List<Integer> result = new ArrayList<>();
        if (x < low) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (x > high) {
            for (int i = arr.length - k; i < arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        int index = doBinary(arr, x);

        int start = index - k + 1;
        if (start >= 0) {
            for (int i = start; i <= index; i++) {
                result.add(arr[i]);
            }
        } else {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    public static int doBinary(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;

            }
            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return left;

    }
}
