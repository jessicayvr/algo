package amazon;

import model.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Starting at top left corner can move one block up, down, left or right at a time.
 * Treasure: 9
 * 1 is safe
 * 0 is not safe cannot enter
 *
 * Output the minimum number of steps to get to the treasure.
 *
 * Second
 * Output the minimum number of steps to get to any of the treasure islands.
 * Can only start at 1
 * 5 is safe to sail
 *
 */
public class treasureIsland {

    public static int findTreasureII(int[][] m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                if (m[i][j] == 1) {
                    min = Math.min(findTreasure(m, i, j), min);
                }
            }
        }
        return min;
    }

    public static int findTreasureI(int[][] m) {
        return findTreasure(m, 0, 0);
    }

    public static int findTreasure(int[][] m, int i, int j) {
        boolean[][] visited = new boolean[m.length][m[0].length];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j, 0));

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            int x = poll.getX();
            int y = poll.getY();
            int val = poll.getVal();
            if (m[x][y] == 9) {
                return val;
            }

            isSafe(m, visited, x, y, q, val);
        }

        return -1;
    }

    private static void isSafe(int[][] m, boolean[][] visited, int x, int y, Queue<Pair> q, int val) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int i = dx[k] + x;
            int j = dy[k] + y;

            if (i >= 0 && j >= 0 && i < m.length && j < m[0].length && !visited[i][j] && m[i][j] != 0) {
                visited[i][j] = true;
                q.add(new Pair(i, j, val + 1));
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 0, 0},
                {1, 0, 0},
                {1, 9, 1}};


        int[][] x = new int[][]{{1, 1, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1},
                {9, 0, 0, 1}};

        int[][] m_2nd = new int[][]{{1, 5, 5, 1, 1},
                {0, 5, 0, 5, 0},
                {5, 5, 5, 5, 9},
                {9, 0, 0, 5, 5},
                {9, 0, 0, 0, 5}};


        int treasureI = findTreasureI(x);
        System.out.println("First iteration: " + treasureI);
        int treasureII = findTreasureII(m_2nd);
        System.out.println("Second iteration: " + treasureII);
    }
}
