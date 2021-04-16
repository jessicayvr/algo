package problems.integer;

/**
 * O(n+m)
 */
public class search2DMatrix {

    public static void main(String[] args) {
       int[][] m = new int[][] {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

       int n = 76;
       System.out.println(findN(m, n));
    }

    private static boolean findN(int[][] m, int n) {
        int row = 0;
        int col = m[0].length-1;

        while (row < m.length && col >= 0) {
            if (m[row][col] == n) {
                return true;
            }
            if (m[row][col] > n) {
                col--;
            } else {
                row ++;
            }
        }

        return false;
    }
}
