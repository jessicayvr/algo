package problems.matrix;

// O(mn)
public class lillian {
    public static void main(String[] args) {
//        int[][] m = new int[][]{
//                {5, 7, 8, 6, 3},
//                {0, 0, 7, 0, 4},
//                {4, 6, 3, 4, 9},
//                {3, 1, 0, 5, 8}};

        int[][] x = new int[][]{
                {1, -1},
                {1, 4}
        };

        boolean max = findTarget(x, 5);
        System.out.println(max);
    }

    private static boolean findTarget(int[][] m, int target) {

        boolean[][] visited = new boolean[m.length][m[0].length];

        // for each square find if there exists at path
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == target) {
                    return true;
                }
                if (findTarget(i, j, m, target, visited, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean findTarget(int i, int j, int[][] m, int target, boolean[][] visited, int cur) {
        // current number at position
        int pos = m[i][j];
        visited[i][j] = true;

        // calculate new number
        cur = pos + cur;

        // if cur is the target, winner
        if (cur == target) {
            return true;
        }

        // this represents the movement, in order we will always check up, right, down, left
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {

            // fetch x,y coordinate
            int x = dx[k] + i;
            int y = dy[k] + j;

            // if the x y coordinate are out of bound or already visited skip
            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && !visited[x][y]) {

                // findTarget on the next square
                if (findTarget(x, y, m, target, visited, cur)) {
                    // if down this path we find something return true and exit out back to main caller
                    return true;
                }
            }
        }

        // if we exhausted all the potential moves then mark the current position unvisited and return false
        // goes back to line 67 (findTarget returns false, so now at that place the code checks the next movement (up,right,left,down)

        visited[i][j] = false;
        return false;
    }
}
