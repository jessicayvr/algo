package problems.integer;

public class findPeakElement {
    //O(lgn)
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 1};
        System.out.print(findPeak(num, 0, num.length - 1));

        System.out.println(findPeak2(num));
    }

    private static int findPeak(int[] num, int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        // need to compare with mid+1 instead of mid-1
        // if theres only two elements then mid is 0, can't compare with [mid-1]
        if (num[mid] > num[mid + 1]) {
            return findPeak(num, start, mid);
        } else {
            return findPeak(num, mid + 1, end);
        }
    }

    private static int findPeak2(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = (left+right)/2;

            if (nums[mid] >= nums[mid+1]) {
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
}
