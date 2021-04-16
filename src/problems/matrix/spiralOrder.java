package problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };

        spiralOrder(m);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int xs = 0;
        int ys = 0;
        int xe = matrix.length-1;
        int ye = matrix[0].length-1;

        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (xs <= xe && ys <= ye) {

            while (i <= ye) {
                res.add(matrix[xs][i]);
                i++;
            }
            xs++;

            i = xs;
            while (i <= xe) {
                res.add(matrix[i][ye]);
                i++;
            }
            ye--;

            i = ye;
            while (i >= ys) {
                res.add(matrix[xe][i]);
                i--;
            }
            xe--;

            i = xe;
            while (i >= xs) {
                res.add(matrix[i][ys]);
                i--;
            }
            ys++;
            i = xs;
        }
        return res;
    }
}
