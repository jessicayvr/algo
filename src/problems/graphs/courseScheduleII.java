package problems.graphs;

import model.Graph;

import java.util.*;

public class courseScheduleII {
    /**
     * Return the ordering of courses you should take to finish all courses. Just one answer is fine.
     */
    public static void main(String[] args) {
        // int[][] input = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] intput = new int[][]{{1, 0}};
        int[] order = findOrder(2, intput);
        System.out.print(order);
    }

    /**
     * O(N) = O(E+V) since we process each node exactly once and end up processing the entire graph given to us.
     * O(N)
     */
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        // create graph
        Graph g = new Graph(numCourses);
        for (int[] edge : prerequisites) {
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[g.getV()];
        boolean[] stack = new boolean[g.getV()];
        // use queue because we want no dependency to big dependency
        Queue<Integer> q = new LinkedList<>();
        // start processing first vertix
        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i]) {
                // if theres a cycle return empty list
                if (doTopologicalSortIsCycle(g, i, visited, q, stack)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[g.getV()];
        int i = 0;
        while (!q.isEmpty()) {
            result[i] = (q.remove());
            i++;
        }
        return result;
    }

    private static boolean doTopologicalSortIsCycle(Graph g, int v, boolean[] visited, Queue<Integer> q, boolean[] stack) {
        if (stack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }
        visited[v] = true;
        stack[v] = true;
        Iterator<Integer> iterator = g.getAdj().get(v).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (doTopologicalSortIsCycle(g, next, visited, q, stack)) {
                return true;
            }
        }

        q.add(v);
        stack[v] = false;
        return false;
    }
}
