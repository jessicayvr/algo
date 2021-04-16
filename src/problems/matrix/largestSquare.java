package problems.matrix;

public class largestSquare {

    private static int largest(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        int res = 0;

        // copy first column
        for (int i = 0; i < m.length; i++) {
            dp[i][0] = m[i][0];
        }

        // copy first row
        for (int i = 0; i < m[0].length; i++) {
            dp[0][i] = m[0][i];
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    if (res < dp[i][j]) {
                        res = dp[i][j];
                    }
                }

            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] m = {{1,0,1,0},
                    {1,1,1,1} ,
                    {1,1,1,1},
                    {0,1,1,1}};

        int largest = largest(m);
        System.out.println("largest square is: " + largest);
    }
}
