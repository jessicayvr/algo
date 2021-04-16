package problems.graphs;

import model.Graph;

import java.util.Iterator;

public class isUndirectedGraphCyclic {

    // is cyclic if next is visited and parent does not equal next;
    // if parent == next that means they have an edge
    public boolean isCyclic(Graph g) {

        int v = g.getV();
        boolean[] visited = new boolean[g.getV()];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (doUtil(i, visited, -1, g)) {
                    return true;
                };
            }
        }
        return false;
    }

    private boolean doUtil(int i, boolean[] visited, int parent, Graph g) {
        visited[i] = true;
        Iterator<Integer> iterator = g.getAdj().get(i).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!visited[next]) {
                if (doUtil(next, visited, i, g)) {
                    return true;
                }
            } else if (next != parent) {
                return true;
            }
        }
        return false;
    }
}
