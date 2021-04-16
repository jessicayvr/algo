package problems.matrix;

public class maze {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 9, 0, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}};

//        int[][] m = new int[][] {
//                {1,0,1},
//                {1,0,1},
//                {1,9,1}};

        System.out.print(doMaze(m));
    }

    private static boolean doMaze(int[][] m) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        return doMazeUtil(0, 0, m, visited);
    }

    private static boolean doMazeUtil(int i, int j, int[][] m, boolean[][] visited) {
        visited[i][j] = true;
        if (m[i][j] == 9) {
            return true;
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] != 0 && !visited[x][y]) {
                if (doMazeUtil(x, y, m, visited)){
                    return true;
                };
            }
        }
        return false;
    }
}
