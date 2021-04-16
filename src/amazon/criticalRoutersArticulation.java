package amazon;

import java.util.*;

/**
 * O(E+V)
 *
 * ArticulationPoint can be found if there is a bridge (id < low[next]) or if there is a cycle (id == low[next])
 */
public class criticalRoutersArticulation {

    public static void main(String[] args) {
        int numNodes = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};

        List<Integer> articulationPoint = findArticulationPoint(numNodes, edges);
        System.out.println(articulationPoint);
    }

    // calculates number of out going edges of root
    // private static int numOutEdges;

    private static List<Integer> findArticulationPoint(int numNodes, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numNodes; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int numOutEdges;
        int[] lowLink = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        List<Integer> art = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                numOutEdges = 0;
                numOutEdges = doDFS(i, visited, lowLink, map, art, -1, i, numOutEdges);

                // remove if the root does not have more than 1 out going edges
                if (art.contains(i) && numOutEdges <= 1) {
                    art.remove((Object) i );
                }
            }
        }

        return art;
    }

    private static int doDFS(int i, boolean[] visited, int[] lowLink, Map<Integer, List<Integer>> map, List<Integer> art, int parent, int root, int numOutEdges) {
        lowLink[i] = i;
        visited[i] = true;
        if (parent == root) {
            numOutEdges++;
        }
        Iterator<Integer> adj = map.get(i).iterator();
        while (adj.hasNext()) {
            Integer next = adj.next();
            if (next == parent) {
                continue;
            }
            if (!visited[next]) {
                numOutEdges =  doDFS(next, visited, lowLink, map, art, i, root, numOutEdges);
                lowLink[i] = Math.min(lowLink[i], lowLink[next]);

                // bridge if id < lowlink next
                if (i < lowLink[next]) {
                    art.add(i);
                }
                // cycle if ID = lowlink next
                if (i == lowLink[next]) {
                    art.add(i);
                }
            } else {
                lowLink[i] = Math.min(lowLink[i], next);
            }
        }
        return numOutEdges;
    }

}