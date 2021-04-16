package problems.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * time: O(m * n), you have to transverse every cell
 * space: O(m * n) for worst-case
 */
public class numberOfIslandDFS_BFS {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};


        int dfs = findNumIslandDFS(m);
        System.out.println(dfs);

        int bfs = findNumIslandBFS(m);
        System.out.println(bfs);
    }

    private static int findNumIslandBFS(int[][] m) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        int count = 0;
        for (int i = 0 ; i < m.length; i++) {
            for (int j = 0 ; j < m[0].length; j++) {
                if (m[i][j] == 1 && !visited[i][j]) {
                    doBFS(i, j , m, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void doBFS(int i, int j, int[][] m, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int[] dx = new int[] {-1, 0, 1, 0};
            int[] dy = new int[] {0 ,1, 0, -1};

            for (int k = 0 ; k < 4; k++) {
                int x = poll[0] + dx[k];
                int y = poll[1] + dy[k];

                if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] == 1 && !visited[x][y]) {
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
    }

    private static int findNumIslandDFS(int[][] m) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        int count = 0;
        for (int i = 0 ; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (!visited[i][j] && m[i][j] == 1) {
                    doNumDFS(i, j , m, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void doNumDFS(int i, int j, int[][] m, boolean[][] visited) {
        visited[i][j] = true;

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0 ,1, 0, -1};

        for (int k = 0 ; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x >=0 && y>=0 && x < m.length && y < m[0].length && m[x][y] == 1 && !visited[x][y]) {
                doNumDFS(x, y, m, visited);
            }
        }
    }
}
