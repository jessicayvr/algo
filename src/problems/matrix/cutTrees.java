package problems.matrix;

import model.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class cutTrees {

    public static void main(String[] args) {
        int[][] tree = new int[][]{
                {1, 2, 3},
                {0, 0, 4},
                {7, 6, 5}
        };

        int[][] forest = new int[][] {
            {2,3,4},
            {0,0,5},
            {8,7,6}
        };

        int[][] bad = new int[][] {
                {1,2,3},
                {0,0,0},
                {8,7,6}
        };
        int i = cutOffTree(bad);
        System.out.print(i);
    }

    public static int cutOffTree(int[][] forest) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getVal));

        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[0].length; j++) {
                if (forest[i][j] != 0) {
                    pq.add(new Pair(i, j, forest[i][j]));
                }
            }
        }

        int x = 0;
        int y = 0;
        int numSteps = 0;
        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int shortestPath = findShortestPath(x, y, poll, forest);
            if (shortestPath == -1) {
                return -1;
            }
            x = poll.getX();
            y = poll.getY();
            numSteps = shortestPath + numSteps;
            forest[poll.getX()][poll.getY()] =1;
        }
        return numSteps;
    }

    private static int findShortestPath(int x, int y, Pair dest, int[][] forest) {
        boolean[][] visited = new boolean[forest.length][forest[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, 0));

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int x1 = poll.getX();
            int y1 = poll.getY();
            int val = poll.getVal();

            if (x1 == dest.getX() && y1 == dest.getY()) {
                return val;
            }

            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};

            for (int k = 0 ; k < 4; k++) {
                int i = x1 + dx[k];
                int j = y1 + dy[k];

                if (i >= 0 && j >=0 && i < forest.length && j <forest[0].length && forest[i][j] != 0 & !visited[i][j] ) {
                    visited[i][j] = true;
                    q.add(new Pair(i, j, val + 1));
                }
            }
        }
        return -1;
    }


}
