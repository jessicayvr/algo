package problems.matrix;

/**
 * The values of the matrix will represent numbers of carrots
 * available to the rabbit in each square of the garden. If the garden
 * does not have an exact center, the rabbit should start in the
 * square closest to the center with the highest carrot count.
 * On a given turn, the rabbit will eat the carrots available on the
 * square that it is on, and then move up, down, left, or right,
 * choosing the the square that has the most carrots. If there are no
 * carrots left on any of the adjacent squares, the rabbit will go to
 * sleep. You may assume that the rabbit will never have to choose
 * between two squares with the same number of carrots.
 */
public class hungryRabbit {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {5, 7, 8, 6, 3},
                {0, 0, 7, 0, 4},
                {4, 6, 3, 4, 9},
                {3, 1, 0, 5, 8}};

        int max = doHungryRabbit(m);
        System.out.println(max);
    }

    private static int doHungryRabbit(int[][] m) {
        // find middle index x,y
        int[] middleIndex = findMiddleIndex(m);
        boolean[][] visited = new boolean[m.length][m[0].length];
        return calculateCarrots(middleIndex[0], middleIndex[1], m, visited, 0);
    }

    private static int calculateCarrots(int i, int j, int[][] m, boolean[][] visited, int max) {
        visited[i][j] = true;
        max = max + m[i][j];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cur = 0;
        int[] xy = new int[]{};
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && !visited[x][y]) {
                int val = m[x][y];
                if (val > cur) {
                    xy = new int[]{x, y};
                    cur = val;
                }
            }
        }
        if (xy.length != 0) {
            max = calculateCarrots(xy[0], xy[1], m, visited, max);
        }
        return max;
    }

    /**
     * @return x, y index
     */
    private static int[] findMiddleIndex(int[][] m) {

        if (m.length % 2 == 1) {
            // there is odd number of rows;
            int[] colMiddleIndex1 = findColMiddleIndex(m[m.length / 2]);
            return new int[]{m.length / 2, colMiddleIndex1[1]};
        } else {
            int[] colMiddleIndex = findColMiddleIndex(m[(m.length / 2) - 1]);
            int[] colMiddleIndex1 = findColMiddleIndex(m[m.length / 2]);

            if (colMiddleIndex[0] > colMiddleIndex1[0]) {
                return new int[]{(m.length / 2) - 1, colMiddleIndex[1]};
            } else {
                return new int[]{m.length / 2, colMiddleIndex1[1]};
            }
        }

    }

    /**
     * @return value at position, index
     */
    private static int[] findColMiddleIndex(int[] row) {

        if (row.length % 2 == 1) {
            // there is odd number of rows;
            return new int[]{row[row.length / 2], row.length / 2};
        } else {
            if (row[(row.length / 2) - 1] > row[row.length / 2]) {
                return new int[]{row[(row.length / 2) - 1], (row.length / 2) - 1};
            } else {
                return new int[]{row[row.length / 2], row.length / 2};
            }
        }
    }
}
