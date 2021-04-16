package amazon;

import model.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * O(ElogE) or O(ElogV)
 */
public class minCostToConnectAllNodes {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};

        int i = minMinCost(n, edges, newEdges);
        System.out.println(i);
    }

    private static int minMinCost(int n, int[][] edges, int[][] newEdges) {
        int[] parent = new int[n + 1];
        initalizeParent(parent);

        // first do all of the existing edges
        List<Edge> result = new ArrayList<>();
        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];

            int sourceParent = findParent(parent, source);
            int destParent = findParent(parent, dest);

            if (sourceParent == destParent) {
                // cycle do nothing
            } else {
                union(parent, sourceParent, destParent);
            }
        }

        // create priority queue and add new edges
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));

        for (int[] edge : newEdges) {
            Edge edgek = new Edge(edge[0], edge[1], edge[2]);
            pq.add(edgek);
        }

        // min spam is v-1, since nodes start at index 1 we have to plus one
        // example vertixes = 6, existingEdges = 3, we need to find two more edges to have 5 edges
        int i = edges.length + 1;
        while (i < n) {
            Edge poll = pq.poll();

            int parent1 = findParent(parent, poll.source);
            int parent2 = findParent(parent, poll.destination);

            if (parent1 != parent2) {
                result.add(poll);
                i++;
                union(parent, parent1, parent2);
            }
        }

        return result.stream().map(x -> x.weight)
                .reduce(0, Integer::sum);
    }

    private static void union(int[] parent, int sourceParent, int destParent) {
        int parent1 = findParent(parent, sourceParent);
        int parent2 = findParent(parent, destParent);

        parent[parent2] = parent1;
    }

    private static int findParent(int[] parent, int vertix) {
        int vertixParent = parent[vertix];
        if (vertixParent != vertix) {
            return findParent(parent, vertixParent);
        }
        return vertixParent;

    }

    private static void initalizeParent(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
}
