package problems.problems;

public class rangeSumQuery {

    public static void main(String[] args) {
        int[] nums = new int[] { -2, 0, 3, -5, 2, -1};
        numArray(nums, 0 , 2);
    }

    public static int numArray(int[] nums, int j, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        return sum[k + 1] - sum[j];
    }
}
