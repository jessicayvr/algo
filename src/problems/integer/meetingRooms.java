package problems.integer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class meetingRooms {
    public static void main(String[] args) {
       int[][] time = new int[][] {{0, 30},{5, 10},{15, 20}};
   //    System.out.println(meetingRoomI(time));

       System.out.println(meetingRoomIIPQ(time));
    }

    private static boolean meetingRoomI(int[][] time) {
        Arrays.sort(time, Comparator.comparingInt(x->x[0]));

        for (int i = 0; i <time.length-1; i++) {
            if (time[i][1] >= time[i+1][1]) {
                return false;
            }
        }
        return true;
    }

    private static int meetingRoomIIPQ(int[][] time) {
        Arrays.sort(time, Comparator.comparingInt(x->x[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(time[0][1]);

        for (int i = 1; i < time.length; i++) {
            // check if current start is after latest meeting end
            // if it is, then the meeting room is freed up, remove from pq
            if (time[i][0] > pq.peek()) {
                pq.poll();
            }
            pq.add(time[i][1]);
        }
        return pq.size();
    }

    // like train platform
    private static int meetingRoomII(int[][] time) {
       int[] start = new int[time.length];
       int[] end = new int[time.length];
       for (int i = 0; i < time.length; i++) {
           start[i] = time[i][0];
           end[i] = time[i][1];
       }
       Arrays.sort(start);
       Arrays.sort(end);

       int i = 1;
       int j = 0;
       int cur = 1;
       int result = 1;

       while (i < time.length && j < time.length) {
           if (start[i] < end[j]) {
               i++;
               cur++;
           } else {
               j++;
               cur--;
           }

           if (cur > result) {
               result = cur;
           }
       }
       return result;
    }
}
