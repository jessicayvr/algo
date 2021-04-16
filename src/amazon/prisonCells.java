package amazon;

import java.util.Arrays;

public class prisonCells {

    public static void main(String[] args) {
        int[] cells = new int[]{1,1,1,0,1,1,1,1};
        int n = 2;
//    Output: [0,0,1,1,0,0,0,0]
        doCells(cells, n);
        //  System.out.println(Arrays.toString(newCells));
    }

    private static int[] doCells(int[] cells, int n) {


        int[] newCells = new int[cells.length];
        System.out.println("Day: 0  " + Arrays.toString(cells));
        int i = 1;

       // N = N < 14 ? N : (N % 14) + 14;
        while (i <= n) {
            newCells = new int[8];
            for (int j = 1; j < cells.length - 1; j++) {
                if ((cells[j - 1] == 0 && cells[j + 1] == 0) || (cells[j - 1] == 1 && cells[j + 1] == 1)) {
                    newCells[j] = 0;
                } else {
                    newCells[j] = 1;
                }
            }
            cells = newCells;
            System.out.println("Day: " + i + "  " + Arrays.toString(newCells));
            i++;
        }

        return newCells;
    }
}
