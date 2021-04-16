package problems.matrix;

import static problems.HelperUtil.printMatrix;

public class rotateMatrix {

    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(m);
        printMatrix(m);
    }
    public static void rotate(int[][] m) {
        int length = m.length;
        // how many boarders
        for (int i = 0; i < length/2; i++) {

            // length of the boarder side
            for (int j = i; j < length-1-i; j++) {

                int temp = m[length-1-j][i];
                m[length-1-j][i] = m[i][j];
                m[i][j] = m[j][length - 1- i];
                m[j][length - 1- i] = m[length -1-i][length-1-j];
                m[length -1-i][length-1-j] = temp;
            }
        }
    }
}
