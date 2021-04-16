package problems.matrix;

public class gameOfLife {
    public static void main(String[] args) {
        int[][] m = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        doGame(m);
    }

    private static void doGame(int[][] m) {
        int[][] board = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    int i1 = doLiveCells(i, j, m);
                    board[i][j] = i1;
                } else {
                    int i2 = doDeadCell(i, j, m);
                    board[i][j] = i2;
                }
            }
        }
        System.out.print("done");
    }

    private static int doDeadCell(int i, int j, int[][] m) {
        int live = 0;

        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

        for (int k = 0; k < 8; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] == 1) {
                live++;
            }
        }

        int result = 0;
        if (live == 3) {
            result =  1;
        }
        return result;
    }

    private static int doLiveCells(int i, int j, int[][] m) {
        int live = 0;

        int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

        for (int k = 0; k < 8; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] == 1) {
                live++;
            }
        }

        int result = 0;
        if (live == 2 || live == 3) {
            result =  1;
        }
        return result;
    }
}
