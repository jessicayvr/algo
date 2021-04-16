package amazon;

import model.Edge;

import java.util.*;

public class minCostToRepairEdges {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[][] edgesToRepair = {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
        int minCost = findMinCost(n, edges, edgesToRepair);
        System.out.println(minCost);


        int[][] a = {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}};
        int[][] b = {{1, 6, 410}, {2, 4, 800}};
        int c = findMinCost(6, a, b);
        System.out.println(c);


        int[][] d = {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}};
        int[][] e = {{1, 5, 110}, {2, 4, 84}, {3, 4, 79}};
        int f = findMinCost(6, d, e);
        System.out.println(f);

    }

    private static int findMinCost(int n, int[][] edges, int[][] edgesToRepair) {
        Map<Integer, List<Integer>> m = new HashMap<>();

        for (int[] reparableEdge : edgesToRepair) {
            if (m.containsKey(reparableEdge[0])) {
                List<Integer> integers = m.get(reparableEdge[0]);
                integers.add(reparableEdge[1]);
                m.put(reparableEdge[0], integers);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(reparableEdge[1]);
                m.put(reparableEdge[0], list);
            }
        }
        List<List<Integer>> existingEdge = new ArrayList<>();
        for (int[] exist : edges) {
            if (m.containsKey(exist[0])) {
                List<Integer> integers = m.get(exist[0]);
                if (!integers.contains(exist[1])) {
                    existingEdge.add(Arrays.asList(exist[0], exist[1]));
                }
            } else {
                existingEdge.add(Arrays.asList(exist[0], exist[1]));
            }
        }

        //nodes start at 1
        int[] parent = new int[n + 1];
        initializeParent(parent);
        for (List<Integer> edge : existingEdge) {
            int source = edge.get(0);
            int dest = edge.get(1);

            int parent1 = findParent(parent, source);
            int parent2 = findParent(parent, dest);

            if (parent1 != parent2) {
                union(parent, parent1, parent2);
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k.weight));
        for (int[] edge : edgesToRepair) {
            pq.add(new Edge(edge[0], edge[1], edge[2]));
        }

        int max = 0;
        int i = existingEdge.size() + 1;
        while (i < n) {
            Edge poll = pq.poll();
            int source = poll.source;
            int dest = poll.destination;

            int parent1 = findParent(parent, source);
            int parent2 = findParent(parent, dest);

            if (parent1 != parent2) {
                union(parent, parent1, parent2);
                i++;
                max = max + poll.weight;
            }
        }

        return max;

    }

    private static void union(int[] parent, int parent1, int parent2) {
        int parent3 = findParent(parent, parent1);
        int parent4 = findParent(parent, parent2);

        parent[parent3] = parent4;
    }

    private static int findParent(int[] parent, int vertix) {
        int vertixParent = parent[vertix];
        if (vertixParent != vertix) {
            return findParent(parent, vertixParent);
        }
        return vertixParent;
    }

    private static void initializeParent(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
}
