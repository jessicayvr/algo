package problems.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

//O(lgn)
public class findMedian {

    public static void main(String[] args) {
        MedianFinder med = new MedianFinder();
        med.addNum(1);
        med.addNum(2);
        System.out.println(med.findMedian()); // 1.5
        med.addNum(3);
        System.out.println(med.findMedian()); // 2
    }

    static class MedianFinder {
        // max heap (everything smaller than median)
        PriorityQueue<Integer> lower;

        // min head (everything bigger than median)
        PriorityQueue<Integer> upper;

        public MedianFinder() {
            this.lower = new PriorityQueue<>(Comparator.reverseOrder());
            this.upper = new PriorityQueue<>();
        }

        // O(lgn)
        public void addNum(int num) {
            // add to lower if lower size = 0 or if lower peek is bigger than num
            if (lower.size() == 0 || lower.peek() > num) {
                lower.add(num);


                // re shuffle is diff between the two heaps is greater than 1
                if (lower.size() > upper.size() && lower.size() - upper.size() > 1) {
                    upper.add(lower.poll());
                }
            } else {
                upper.add(num);
                // re shuffle is diff between the two heaps is greater than 1
                if (upper.size() > lower.size() && upper.size() - lower.size() > 1) {
                    lower.add(upper.poll());
                }
            }
        }
        // O(1)
        // if return peek of bigger size
        // else add two peeks / 2
        public double findMedian() {
            if (lower.size() > upper.size()) {
                return lower.peek();
            } else if (upper.size() > lower.size()) {
                return upper.peek();
            } else {
                // equal size
                return (lower.peek() + upper.peek()) / 2d;
            }
        }
    }
}
