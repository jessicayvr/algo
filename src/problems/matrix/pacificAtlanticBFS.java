package problems.matrix;

import java.util.*;

public class pacificAtlanticBFS {

    public static void main(String[] args) {
        /**
         * Two Queues: Pacific border to one queue; Atlantic border to another queue.
         * Keep a visited matrix for each queue.
         * Keep adding to respective queue if neighbour is bigger than current.
         * Once both q's are empty, add cell VISITED by both queues
         */

        /**
         *   Pacific ~   ~   ~   ~   ~
         *        ~  1   2   2   3  (5) *
         *        ~  3   2   3  (4) (4) *
         *        ~  2   4  (5)  3   1  *
         *        ~ (6) (7)  1   4   5  *
         *        ~ (5)  1   1   2   4  *
         *           *   *   *   *   * Atlantic
         */
        int[][] ocean = new int[][]
                {{1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}};

        List<List<Integer>> lists = pacificAtlantic(ocean);
        System.out.print(lists);
    }

    private static List<List<Integer>> pacificAtlantic(int[][] m) {
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        boolean[][] visitedPac = new boolean[m.length][m[0].length];
        boolean[][] visitedAtlan = new boolean[m.length][m[0].length];

        // vertical boarder
        for (int i = 0; i < m.length; i++) {
            pacificQ.add(new int[]{i, 0});
            atlanticQ.add(new int[]{i, m[0].length - 1});
            visitedPac[i][0] = true;
            visitedAtlan[i][m[0].length - 1] = true;
        }

        // horizontal border
        for (int i = 0; i < m[0].length; i++) {
            pacificQ.add(new int[]{0, i});
            atlanticQ.add(new int[]{m.length - 1, i});
            visitedPac[0][i] = true;
            visitedAtlan[m.length - 1][i] = true;
        }

        doBFS(m, pacificQ, visitedPac);
        doBFS(m, atlanticQ, visitedAtlan);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (visitedAtlan[i][j] && visitedPac[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void doBFS(int[][] m, Queue<int[]> q, boolean[][] visited) {

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            int[] dx = new int[]{-1, 0, 1, 0};
            int[] dy = new int[]{0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int i = dx[k] + x;
                int j = dy[k] + y;

                if (i >= 0 && j >= 0 && i < m.length && j < m[0].length && m[i][j] >= m[x][y] && !visited[i][j]) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }
    }
}
