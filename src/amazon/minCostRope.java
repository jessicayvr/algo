package amazon;

import java.util.*;


/**
 * Time complexity: O(nlogn). sorts in nlogn
 * Space complexity: O(n).
 *
 * import java.util.PriorityQueue;
 *
 */
public class minCostRope {

    public static void main(String[] args) {
        int[] rope = new int[]{};
        int minCost = findMinCost(rope);

        System.out.println(minCost);

    }

    private static int findMinCost(int[] ropes) {

        Queue<Integer> q = new PriorityQueue<>();
        for (int rope : ropes) {
            q.add(rope);
        }
        int max = 0;
        // make sure q is greater than 1 for rope with 1 size.
        while (q.size() > 1) {
            Integer poll = q.poll();
            Integer poll2 = q.poll();

            int sum = poll + poll2;
            max = max + sum;
            q.add(sum);
        }
        return max;
    }
}
