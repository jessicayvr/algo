package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class rottingOranges {
    public static void main(String[] args) {
        /**
         * In a given grid, each cell can have one of three values:
         *
         * the value 0 representing an empty cell;
         * the value 1 representing a fresh orange;
         * the value 2 representing a rotten orange.
         * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
         *
         * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
         * If this is impossible, return -1 instead.
         */
        int[][] m = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(m);
    }
    // O(N)
    public static int orangesRotting(int[][] m) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 2) {
                    q.add(new int[]{i,j});
                } else if (m[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int iter = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            iter++;
            for (int h = 0; h < size; h++) {
                int[] p = q.poll();

                int[] dy = new int[] {0,1,0,-1};
                int[] dx = new int[]{-1,0,1,0};

                for (int k = 0; k < 4; k ++) {
                    int x = p[0] + dx[k];
                    int y = p[1] + dy[k];

                    if (x>=0 && y >= 0 && x<m.length && y<m[0].length && m[x][y] == 1) {
                        m[x][y] = 2;
                        q.add(new int[]{x,y});
                        fresh--;
                    }

                }
            }
        }
        return fresh > 0 ? -1 : iter;
    }
}
