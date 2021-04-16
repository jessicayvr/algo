package problems.integer;

public class moveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.print(nums);
    }

    public static void moveZeroes(int[] nums) {
        int i = 0 ;

        // j points to zeros, place to swap to
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] != 0) {
                swap(nums, i , j);
                j++;
            }
            i++;
        }

    }
    public static void swap(int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
