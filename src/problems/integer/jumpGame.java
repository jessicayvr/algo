package problems.integer;

public class jumpGame {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};

        /*
        2,3,1,1,4
        -----
          -------
         */
        jump(nums);
        System.out.print(canJump(new int[]{3,2,1,0,4}));
    }
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int ladder = nums[0];
        int stairs = nums[0];
        int jumps = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums.length - 1  == i) {
                return jumps;
            }

            if (nums[i] + i > ladder) {
                ladder = nums[i] + i;
            }
            stairs--;
            if (stairs == 0) {
                jumps++;
                stairs = ladder- i;
            }
        }
        return jumps;
    }

    public static boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max == 0) {
                return false;
            }
            if (i == nums.length-1) {
                return true;
            }
            if (nums[i] + i > max) {
                max = nums[i] + i;
            } else if (nums[i]==0 && i == max) {
                return false;
            }
        }
        return max >= nums.length-1;
    }
}
