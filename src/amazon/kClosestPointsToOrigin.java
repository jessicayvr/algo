package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 */
public class kClosestPointsToOrigin {
    public static void main(String[] args) {

        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int[][] hell = hell(points, 2);

        System.out.println(hell);

    }

    /**
     * -1 means current is less than the existing
     * 1 means current is bigger than the existing
     */
    public static int[][] hell(int[][] points, int k) {
//        Queue<int[]> q = new PriorityQueue<>((current, existing) -> {
//            int sqrtCurrent = (current[0] * current[0]) + (current[1] * current[1]);
//            int sqrtExisting = (existing[0] * existing[0]) + (existing[1] * existing[1]);
//
//            if (Math.sqrt(sqrtCurrent) < Math.sqrt(sqrtExisting)) {
//                return -1;
//            } else {
//                return 1;
//            }
//        });



        // this is the same as above
        Comparator<int[]> comparePoints = new Comparator<int[]>() {
            @Override
            public int compare(int[] current, int[] existing) {
                int sqrtCurrent = (current[0] * current[0]) + (current[1] * current[1]);
                int sqrtExisting = (existing[0] * existing[0]) + (existing[1] * existing[1]);

                if (Math.sqrt(sqrtCurrent) < Math.sqrt(sqrtExisting)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        // PRIORITY QUEUE only returns you the 'priority' in poll, the rest of the queue is not ordered
        // here this is in natural order ascending  0,1,2,3, ..n
        Queue<int[]> q = new PriorityQueue<>(comparePoints);
        for (int[] point : points) {
            q.add(point);
        }

        int i = 0;
        int[][] result = new int[k][];
        while (!q.isEmpty() && i < k) {
            int[] poll = q.poll();
            result[i] = poll;
            i++;
        }

        return result;

    }
}
