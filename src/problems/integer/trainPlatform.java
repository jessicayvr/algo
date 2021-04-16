package problems.integer;

import java.util.Arrays;

public class trainPlatform {
    // O(n* nlgn)
    public static void main(String[] args) {
        int[] arrival = new int[]{100, 140, 150, 200, 215, 400};
        int[] departure = new int[]{110, 300, 220, 230, 315, 600};

        System.out.print(numberOfPlatforms(arrival, departure));
    }

    private static int numberOfPlatforms(int[] arrival, int[] departure) {
        // O(nlogn)
        Arrays.sort(arrival);
        Arrays.sort(departure);

        // arrival pointer
        int i = 1;

        // departure pointer
        int j = 0;

        // min is always 1
        int res = 1;
        int cur = 1;
        while (i < arrival.length && j < departure.length) {
            // if departure  < arrival that means train has left
            if (departure[j] < arrival[i]) {
                j++;
                cur--;
            } else {
                i++;
                cur++;
            }

            if (cur > res) {
                res = cur;
            }
        }
        return res;
    }
}
