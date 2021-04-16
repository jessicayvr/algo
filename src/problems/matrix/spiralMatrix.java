package problems.matrix;

/**
 * O(mn)
 */
public class spiralMatrix {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = doSpiralMatrix(n);
        print2D(matrix);
    }

    private static int[][] doSpiralMatrix(int n) {
        int[][] m = new int[n][n];
        int row_beg = 0;
        int row_end = n - 1;
        int col_beg = 0;
        int col_end = n - 1;

        int count = 1;
        int i = col_beg;
        while (col_beg <= col_end && row_beg <= row_end) {
            while (i <= col_end) {
                m[row_beg][i] = count++;
                i++;
            }

            row_beg++;
            i = row_beg;
            while (i <= row_end) {
                m[i][col_end] = count++;
                i++;
            }
            col_end--;
            i = col_end;

            while (i >= col_beg) {
                m[row_end][i] = count++;
                i--;
            }

            row_end--;
            i = row_end;

            while (i >= row_beg) {
                m[i][col_beg] = count++;
                i--;
            }

            col_beg++;
            i = col_beg;
        }

        return m;
    }


    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }

}
