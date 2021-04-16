package amazon;

import java.util.*;

/**
 * O(V+E) update low link values in one pass
 * Bridges when removed, makes the graph disconnected (or more precisely,
 * increases the number of connected components in the graph).
 */
public class criticalConnectionsBridges {
    public static void main(String[] args) {
        int vertix = 5;
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};

        List<List<Integer>> lists = criticalBridges(vertix, edges);

        System.out.println(lists);

    }

    private static List<List<Integer>> criticalBridges(int vertix, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        List<List<Integer>> bridges = new ArrayList<>();
        for (int[] edge : edges) {
            int k = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(k, k1 -> new HashSet<Integer>());
            adjList.get(k).add(v);
            adjList.computeIfAbsent(v, v1 -> new HashSet<Integer>());
            adjList.get(v).add(k);
        }

        Set<Integer> visited = new HashSet<>();
        // node number, low link id
        Map<Integer, Integer> lowLink = new HashMap<>();
        // node number, unique id
        Map<Integer, Integer> ids = new HashMap<>();

        int idCount = -1;
        for (Map.Entry<Integer, Set<Integer>> v : adjList.entrySet()) {
            Integer key = v.getKey();

            if (!visited.contains(key)) {
                doDFS(key, adjList, lowLink, ids, visited, -1, bridges, idCount);
            }
        }

        return bridges;
    }

    private static void doDFS(Integer i, Map<Integer, Set<Integer>> adjList, Map<Integer, Integer> lowLink, Map<Integer, Integer> ids, Set<Integer> visited, int parent, List<List<Integer>> bridges, int idCount) {
        visited.add(i);
        idCount = idCount + 1;
        ids.putIfAbsent(i, idCount);
        lowLink.putIfAbsent(i, idCount);

        Iterator<Integer> iterator = adjList.get(i).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == parent) {
                continue;
            }

            if (!visited.contains(next)) {
                doDFS(next, adjList, lowLink, ids, visited, i, bridges, idCount);

                // lowlink value or lowlink value
                Integer value = Math.min(lowLink.get(i), lowLink.get(next));
                lowLink.put(i, value);

                // id value < lowLink value
                if (ids.get(i) < lowLink.get(next)) {
                    bridges.add(Arrays.asList(i, next));
                }

            } else {

                // lowLink value or id value
                Integer value = Math.min(lowLink.get(i), ids.get(next));
                lowLink.put(i, value);
            }
        }
    }
}
