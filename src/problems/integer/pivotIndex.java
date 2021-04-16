package problems.integer;

public class pivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[] {1,7,3,6,5,6};
        System.out.print(pivotIndex(nums));
    }

    // find sum of the array
    // for each i, check if left sum is equal to sum - leftsum - i
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i =0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = sum - leftSum - nums[i];
            if (result == leftSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
