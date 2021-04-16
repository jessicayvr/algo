package algo;

import java.util.*;

/**
 * Use Stack if you want biggest dependency to no dependency
 * Use Queue if you want no dependency to biggest dependency
 */
public class TopologicalInt {

    private int v;
    private List<List<Integer>> adj;

    public TopologicalInt(int v) {
        this.v = v;
        this.adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int x, int y) {
        adj.get(x).add(y);
    }

    private void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                doTopUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    private void doTopUtil(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;

        Iterator<Integer> iterator = adj.get(i).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!visited[next]) {
                doTopUtil(next, visited, stack);
            }
        }
        stack.add(i);
    }

    public static void main(String[] args) {
        TopologicalInt g = new TopologicalInt(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);


        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }

}
