package problems.integer;
/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length
 */
public class removeElementInPlace {

    public static void main(String[] args) {
        int[] n = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.print(removeElement(n, val));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] != val && nums[j] != val) {
                i++;
            } else if (nums[j] != val) {
                swapStuff(nums, i, j);
                i++;
            }
            j++;
        }
        return i;
    }

    private static void swapStuff(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
