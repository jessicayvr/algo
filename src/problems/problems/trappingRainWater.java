package problems.problems;

public class trappingRainWater {

    public static void main(String[] args) {
        int[] rain = {0,1,0,2,1,0,1,3,2,1,2,1};
        int i = doRain(rain);
        System.out.println("Rain displacement: " + i);
    }

    private static int doRain(int[] rain) {

        int n = rain.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // set first left as first rain
        left[0] = rain[0];

        // find the accumlative max
        for (int i = 1; i < rain.length; i++) {
            left[i] = Math.max(left[i-1], rain[i]);
        }

        right[n-1] = rain[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], rain[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int rainDisplacement = Math.min(left[i], right[i]) - rain[i];
            res = rainDisplacement + res;
        }

        return res;

    }
}
