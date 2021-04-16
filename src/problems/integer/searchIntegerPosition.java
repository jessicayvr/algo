package problems.integer;

public class searchIntegerPosition {
    public static void main(String[] args) {
        int[] n = new int[] {1,3};
        searchInsert(n, 4);
    }
    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left+ right)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (left == right && mid == nums.length-1) {
                if (target < nums[mid]) {
                    return mid;
                } else {
                    return nums.length;
                }
            }

            if (right == left && mid == 0 ) {
                if (target < nums[mid]) {
                    return 0;
                } else {
                    return mid + 1;
                }
            }

            if (target > nums[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
