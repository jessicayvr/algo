package algo;

import sun.awt.image.ImageWatched;

import java.util.*;

public class BFS {

    // Time and space: O(V+E)
    public static class Graph {
        private int vertix;
        private List<List<Integer>> adj;

        public Graph(int v) {
            this.vertix = v;
            adj = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adj.add(new LinkedList<>());
            }
        }

        public void addEdge(int x, int y) {
            adj.get(x).add(y);
        }

        public void doBFS(int startingVertix) {
            boolean[] visited = new boolean[vertix];

            // queue
            Queue<Integer> queue = new LinkedList<>();

            queue.add(startingVertix);
            visited[startingVertix] = true;

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();

                System.out.print(" " + poll);

                List<Integer> integers = adj.get(poll);

                Iterator<Integer> iterator = integers.iterator();

                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        public static void main(String args[])
        {
            Graph g = new Graph(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Following is Breadth First Traversal "+
                    "(starting from vertex 2)");

            g.doBFS(2);

            //2 0 3 1
        }
    }

}
