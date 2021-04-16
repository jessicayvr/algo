package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class zombieHourBFS {

    /**
     * if it's all zombies(1) in matrix then return 0
     * if its all humans(0) in matrix then return  -1
     *
     */
    public static void main(String[] args) {
        int[][] m = new int[][]{{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};

        int[][] mm = new int[][]{{1, 1},
                {1, 1}};

        int i = doZombieHour(new int[][]{});
        System.out.println(i);
    }

    private static int doZombieHour(int[][] m) {

        if (m == null || m.length == 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        int people = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    q.add(new int[]{i, j});
                } else {
                    people++;
                }
            }
        }
        int iteration = 0;
        // avoid if map is all zombies
        while (!q.isEmpty() && people > 0) {
            int qSize = q.size();
            iteration++;

            for (int k = 0; k < qSize; k++) {

                int[] poll = q.poll();
                int i = poll[0];
                int j = poll[1];

                int[] dx = new int[]{-1, 0, 1, 0};
                int[] dy = new int[]{0, 1, 0, -1};

                for (int p = 0; p < 4; p++) {
                    int x = i + dx[p];
                    int y = j + dy[p];

                    if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] == 0) {
                        m[x][y] = 1;
                        people--;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        if (people != 0) {
            return -1;
        } else {
            return iteration;
        }

    }
}
