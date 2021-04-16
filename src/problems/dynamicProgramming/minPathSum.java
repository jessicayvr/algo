package problems.dynamicProgramming;

public class minPathSum {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int sum = minPathSum(m);
        System.out.print(sum);
    }

    private static int minPathSum(int[][] grid) {
        int[][] m = new int[grid.length][grid[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == 0 && j == 0) {
                    m[i][j] = grid[i][j];
                } else if (i == 0) {
                    m[i][j] = m[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    m[i][j] = m[i-1][j] + grid[i][j];
                } else {
                    m[i][j] = Math.min(m[i-1][j], m[i][j-1]) + grid[i][j];
                }
            }
        }
        return m[grid.length-1][grid[0].length-1];

    }
}
