package algo;

import java.util.*;

// O(V+E) simply DFS with an extra stack
public class TopologicalString {

    private Map<String, List<String>> adj;

    public TopologicalString() {
        this.adj = new HashMap<>();
    }

    public void addVertix(String v) {
        adj.putIfAbsent(v, new LinkedList<>());
    }

    public void addEdge(String x, String y) {
        adj.get(x).add(y);
    }

    public void topologicalSort() {
        //visited
        Set<String> set = new HashSet<>();

        // dependency list
        Stack<String> stack = new Stack<>();

        Set<String> v = adj.keySet();
        Iterator<String> iterator = v.iterator();

        // go through each vertix
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!set.contains(next)) {
                doTopUtil(next, set, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }

    }

    private void doTopUtil(String v, Set<String> set, Stack<String> stack) {
        set.add(v);

        List<String> strings = adj.get(v);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!set.contains(next)) {
                doTopUtil(next, set, stack);
            }
        }

        // only add to stack if there no more unvisited vertixs
        stack.add(v);
    }

    public static void main(String[] args) {
        TopologicalString top = new TopologicalString();
        top.addVertix("0");
        top.addVertix("1");
        top.addVertix("2");
        top.addVertix("3");
        top.addVertix("4");
        top.addVertix("5");

        top.addEdge("5", "2");
        top.addEdge("5", "0");
        top.addEdge("4", "0");
        top.addEdge("4", "1");
        top.addEdge("2", "3");
        top.addEdge("3", "1");


        top.topologicalSort();
    }
}
