package problems.matrix;

import problems.HelperUtil;

public class setMatrix0 {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeros(m);
        HelperUtil.printMatrix(m);
    }

    // goal is to set first row and column to 0s
    private static void setZeros(int[][] m) {
        boolean col = false;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == 0) {
                col = true;
                break;
            }
        }
        boolean row = false;
        for (int i = 0; i < m[0].length; i++) {
            if (m[0][i] == 0) {
                row = true;
                break;
            }
        }

        // set 0s for first row and first col using inner matrix
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }

        // using first row and col set inner matrix
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[0][j] == 0 || m[i][0] == 0) {
                    m[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int i = 0; i < m[0].length; i++) {
                m[0][i] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < m.length; i++) {
                m[i][0] = 0;
            }
        }
    }
}
