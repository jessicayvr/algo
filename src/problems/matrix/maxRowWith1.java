package problems.matrix;

import java.util.Arrays;

import static problems.HelperUtil.printMatrix;

public class maxRowWith1 {
    // return row
    static int findMax(int[][] m) {

        // sort row
        // O(n*nlgn)
        for (int[] ints : m) {
            Arrays.sort(ints);
        }
        printMatrix(m);

        int j = m[0].length - 1;
        int result = 0;

        // start with top right corner.
        // try to go left until you reach last 1 in that row (jth column)
        // move down 1 row with same column if jth element is 1 try to go left until you find last 1
        for (int i = 0; i < m.length; i++) {
            while (j >= 0 && m[i][j] == 1) {
                j--;
                result = i;
            }
        }
        // max 1s will be m.length-1-j;
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 1},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.print(findMax(arr));
    }
}
