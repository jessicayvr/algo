package amazon;

import java.util.*;

public class bridges {

    public static void main(String[] args) {
        int vertix = 5;
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};

        List<List<Integer>> lists = criticalBridges(vertix, edges);

        System.out.println(lists);

    }

    private static List<List<Integer>> criticalBridges(int vertix, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[1]).add(edge[0]);
        }

        int[] lowlink = new int[vertix + 1];
        boolean[] visited = new boolean[vertix + 1];
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (!visited[key]) {
                doDFS(key, visited, map, lowlink, result, -1);
            }
        }

        return result;
    }

    private static void doDFS(Integer key, boolean[] visited, Map<Integer, Set<Integer>> adj, int[] lowlink, List<List<Integer>> result, int parent) {
        visited[key] = true;
        lowlink[key] = key;

        Iterator<Integer> iterator = adj.get(key).iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(parent)) {
                continue;
            }
            if (!visited[next]) {
                doDFS(next, visited,adj, lowlink, result, key);

                lowlink[key] = Math.min(lowlink[key], lowlink[next]);

                if (key < lowlink[next]) {
                    result.add(Arrays.asList(key, next));
                }
            } else {
                lowlink[key] = Math.min(lowlink[key], next);
            }
        }

    }
}
