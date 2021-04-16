package algo;

import java.util.*;

// O(E+V)
public class DFS {

    public static class Graph {

        private int vertix;
        private List<List<Integer>> adj;

        public Graph(int vertix) {
            this.vertix = vertix;
            adj = new ArrayList<>();
            for (int i = 0 ; i < vertix; i++) {
                adj.add(new LinkedList<>());
            }
        }

        public void addEdge(int x, int y) {
            adj.get(x).add(y);
        }

        public void doDFS(int startVertix) {
            boolean[] visited = new boolean[vertix];

            doDFSUtil(startVertix,visited);

        }

        private void doDFSUtil(int v, boolean[] visited) {

            System.out.println(" " + v);
            visited[v] = true;

            Iterator<Integer> iterator = adj.get(v).iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (!visited[next]) {
                    doDFSUtil(next, visited);
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

            System.out.println("Following is Depth First Traversal "+
                    "(starting from vertex 2)");

            g.doDFS(2);
        }

    }
}
