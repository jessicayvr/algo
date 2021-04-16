package problems.twoPointers;

public class closestPairFromTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 7};
        int[] arr2 = {10, 20, 30, 40};
        int x = 32;

        calculateClosest(arr1, arr2, x);
    }

    private static void calculateClosest(int[] arr1, int[] arr2, int x) {
        int left = 0;
        int right = arr2.length - 1;
        int diff = Integer.MAX_VALUE;

        int res1 = 0;
        int res2 = 0;

        while (left < arr1.length && right >= 0) {
            if (Math.abs(arr1[left] + arr2[right] - x) < diff) {
                diff = Math.abs(arr1[left] + arr2[right] - x);
                res1 = left;
                res2 = right;
            }

            if (arr1[left] + arr2[right] > x) {
                // move to the lesser side
                right--;
            } else {
                // move to the greater side
                left++;
            }
        }

        System.out.print("The closest pair is [" + arr1[res1] +
                ", " + arr2[res2] + "]");
    }
}