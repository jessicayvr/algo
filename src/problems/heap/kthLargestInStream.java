package problems.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class kthLargestInStream {
    static class KthLargest {
        Queue<Integer> q;
        int k;

        // make sure priority queue only has up to k size.
        // the min in the queue is the kth largest
        public KthLargest(int k, int[] nums) {
            q = new PriorityQueue<>();
            this.k = k;
            for (int i : nums) add(i);
        }

        public int add(int val) {
            q.offer(val);
            // 3 > 3 skip
            if (q.size() > k) {
                q.poll();
            }
            return q.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        int k = 3;
        KthLargest largest = new KthLargest(k, arr);
        largest.add(3);
        largest.add(5);
        largest.add(10);
        largest.add(9);
        largest.add(4);

    }
}
