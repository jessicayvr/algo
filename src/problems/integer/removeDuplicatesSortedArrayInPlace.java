package problems.integer;

import javafx.application.Application;
import javafx.stage.Stage;

public class removeDuplicatesSortedArrayInPlace {

    public static void main(String[] args) {
        int [] n =  {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(n);
        System.out.print(i);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i]==nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }
}
