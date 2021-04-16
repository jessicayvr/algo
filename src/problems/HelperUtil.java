package problems;

import java.util.Arrays;

public class HelperUtil {
    public static void printMatrix(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
