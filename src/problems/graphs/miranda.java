package problems.graphs;

import algo.Dijkstra;
import model.Edge;
import model.GraphWeight;

import java.util.*;

public class miranda {

    public static void main(String[] args) {
        GraphWeight g = new GraphWeight(6);
        g.addEdgeWEight(0, 1, 100);
        g.addEdgeWEight(0, 2, 500);
        g.addEdgeWEight(1, 2, 100);

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

    public static int[] doDijstra(List<List<Edge>> adjList, int v, int source) {

        int[] distance = new int[v];

        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        // return the smallest distance, Pair(destination vertix, weightSoFar)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));

        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {

            Pair poll = pq.poll();
            int node = poll.v;
            int d = poll.dist;

            // if distance at vertix is already smaller than distance in pq then skip;
            if (distance[node] < d) {
                continue;
            }

            Iterator<Edge> iterator = adjList.get(node).iterator();

            while (iterator.hasNext()) {
                Edge next = iterator.next();

                int newDistance = distance[node] + next.weight;

                if (distance[next.destination] > newDistance) {

                }
            }
        }
    }
}

