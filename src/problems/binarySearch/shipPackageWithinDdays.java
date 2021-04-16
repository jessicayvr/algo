package problems.binarySearch;

public class shipPackageWithinDdays {
    public static void main(String []args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
    //O(nlgn)
    public static int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum = sum + weights[i];
        }

        int left = 1;
        int right = sum;
        // binary search
        while (left < right) {
            int mid = (left + right)/2;

            if (canShip(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // sum is mid. Is mid shipable?
    public static boolean canShip(int[] weights, int sum, int d) {
        int cur = 0;
        int days = 0;
        for (int i = 0; i < weights.length; i++) {
            cur = cur + weights[i];
            if (weights[i] > sum) {
                return false;
            }

            if (cur > sum) {
                days++;
                cur = weights[i];
            }
        }

        if (cur > 0) {
            days++;
        }
        return days <= d;
    }
}
