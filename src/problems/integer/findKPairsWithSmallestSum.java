package problems.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class findKPairsWithSmallestSum {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        kSmallestPairs(nums1, nums2, k);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] + a[1] < b[0] + b[1]) {
                return -1;
            } else {
                return 1;
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        for (int i = 0; i < nums1.length; i++) {
            // nums1, nums2 index at nums2
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (!pq.isEmpty() && result.size() < k) {
            int[] poll = pq.poll();
            result.add(Arrays.asList(poll[0], poll[1]));
            if (poll[2] < nums2.length - 1) {
                pq.add(new int[]{poll[0], nums2[poll[2] + 1], poll[2] + 1});
            }
        }
        return result;
    }
}
