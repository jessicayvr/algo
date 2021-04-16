package problems.graphs;

import model.Graph;

import java.util.*;

/**
 * DFS
 */
public class isGraphCycle {

    public boolean isGraphCycle(Graph g) {
        boolean[] visited = new boolean[g.getV()];
        boolean[] set = new boolean[g.getV()];


        for (int i = 0; i < g.getV(); i++) {
            if (doCycleUtil(i, visited, set, g)) {
                return true;
            }

        }
        return false;

    }

    private boolean doCycleUtil(int i, boolean[] visited, boolean[] stack, Graph g) {

        if (stack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        stack[i] = true;
        visited[i] = true;

        Iterator<Integer> iterator = g.getAdj().get(i).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();


            if (doCycleUtil(next, visited, stack, g)) {
                return true;
            }

        }

        stack[i] = false;
        return false;
    }
}
