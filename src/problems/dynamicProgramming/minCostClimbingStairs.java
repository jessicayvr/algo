package problems.dynamicProgramming;

public class minCostClimbingStairs {
    public static void main(String[] args) {
        int[] stairs = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(stairs);
    }

    private static int minCostClimbingStairs(int[] cost) {
        int s1 = cost[0];
        int s2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
           int cur = cost[i] + Math.min(s1, s2);
           s1 = s2;
           s2 = cur;
        }
        return Math.min(s1, s2);
    }
}
