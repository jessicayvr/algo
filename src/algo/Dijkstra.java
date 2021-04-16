package algo;

import model.Edge;
import model.GraphWeight;

import java.util.*;

/**
 * O(ElogV)
 * Shortest path
 */
public class Dijkstra {

    public static void main(String[] args) {
        GraphWeight g = new GraphWeight(6);
        g.addEdgeWEight(0, 1, 4);
        g.addEdgeWEight(0, 2, 4);
        g.addEdgeWEight(1, 2, 2);
        g.addEdgeWEight(2, 3, 3);
        g.addEdgeWEight(2, 4, 6);
        g.addEdgeWEight(2, 5, 1);
        g.addEdgeWEight(3, 4, 2);
        g.addEdgeWEight(5, 4, 3);

        int[] shortest = doDijstra(g.adjList, g.v, 0);
        System.out.println(Arrays.toString(shortest));
    }

    public static class Pair {
        int v;
        int dist;

        public Pair(
                int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    public static int[] doDijstra(List<List<Edge>> adjList, int v, int i) {
        boolean[] visited = new boolean[v];

        // distance array from source to node.
        int[] distance = new int[v];
        for (int j = 0; j < v; j++) {
            distance[j] = Integer.MAX_VALUE;
        }
        distance[i] = 0;

        // if you need to print shortest path
        int[] prev = new int[v];
        for (int j = 0; j <v; j++) {
            prev[j] = -1;
        }

        // return the smallest distance, Pair(destination vertix, weightSoFar)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));

        pq.add(new Pair(i, 0));

        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int vertix = poll.v;
            int dist = poll.dist;

            // if vertix is already visited skip;
            if (visited[vertix]) {
                continue;
            }
            visited[vertix] =  true;

            // if distance at vertix is already smaller than distance in pq then skip;
            if (distance[vertix] < dist) {
                continue;
            }

            Iterator<Edge> iterator = adjList.get(vertix).iterator();
            while (iterator.hasNext()) {
                Edge next = iterator.next();
                if (visited[next.destination]){
                    continue;
                }

                int path = dist + next.weight;
                if (path < distance[next.destination]) {
                    pq.add(new Pair(next.destination, path));

                    // distance to destination is current path;
                    distance[next.destination] = path;

                    // update what vertix lead to next.destination;
                    prev[next.destination] = vertix;
                }

            }

        }

      //  route(prev, 4);

        return distance;
    }

    // find route knowing the end
    private static void route(int[] prev, int end) {
        Stack<Integer> pathResult = new Stack<>();
        if (end == -1) {
            // empty path;
        }
        for (int i = end; i != -1; i = prev[i]) {
            pathResult.add(i);
        }

        while (!pathResult.isEmpty()) {
            System.out.print(pathResult.pop());
        }

    }
}