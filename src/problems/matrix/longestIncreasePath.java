package problems.matrix;

// O(m^2 n^2) DFS = O(mn)  + loop in longest
public class longestIncreasePath {

    private static int longest(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        int max = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                int longest = findLongest(i, j, dp, m);
                max = Math.max(max, longest);
            }
        }
        return max;
    }

    private static int findLongest(int i, int j, int[][] dp, int[][] m) {

        // if calculated already just use it
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && y >= 0 && x < dp.length && y < dp[0].length && m[i][j] < m[x][y]) {
                dp[i][j] = Math.max(dp[i][j], findLongest(x, y, dp, m));
            }
        }

        //always add one for yourself
        dp[i][j] = dp[i][j] + 1;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] nums = {{3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}};

        int[][] numss = {{3, 2},
                {4, 5}};

        int longest = longest(numss);
        System.out.println("Print longest: " + longest);
    }
}
