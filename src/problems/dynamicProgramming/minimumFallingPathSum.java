package problems.dynamicProgramming;

public class minimumFallingPathSum {
    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int sum = minFallingPathSum(m);
        System.out.print(sum);
    }

    private static int minFallingPathSum(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        dp[0] = m[0];
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                dp[i][j] = minSum(i, j, m, dp);
            }
        }

        int[] last = dp[m.length - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < last.length; i++) {
            min = Math.min(min, last[i]);
        }
        return min;
    }

    private static int minSum(int i, int j, int[][] m, int[][] dp) {
        int[] dx = new int[]{-1, -1, -1};
        int[] dy = new int[]{-1, 0, 1};
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length) {
                min = Math.min(m[i][j] + dp[x][y], min);
            }
        }
        return min;
    }
}
