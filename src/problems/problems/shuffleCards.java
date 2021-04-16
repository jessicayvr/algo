package problems.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class shuffleCards {

    class Solution {
        int[] orignal;
        int[] current;
        private Random rand = new Random();
        public Solution(int[] nums) {
            orignal = nums;
            current = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            current = orignal;
            orignal = orignal.clone();
            return current;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> copy = new ArrayList<>();
            for (int i = 0; i < current.length; i++) {
                copy.add(current[i]);
            }

            for (int i = 0; i < current.length; i++) {
                int removeIdx = rand.nextInt(copy.size());
                current[i] = copy.get(removeIdx);
                copy.remove(removeIdx);
            }
            return current;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
