package algo;

import model.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * O(ElogE) or O(ElogV).Sorting of edges takes O(ELogE) time.
 * After sorting, we iterate through all edges and apply find-union algorithm.
 * The find and union operations can take atmost O(LogV) time.
 * So overall complexity is O(ELogE + ELogV) time.
 * The value of E can be atmost O(V2), so O(LogV) are O(LogE) same.
 * Therefore, overall time complexity is O(ElogE) or O(ElogV)
 */
public class Kruskal {
    // finds MIN SPANNING TREE
    public static void main(String[] args) {
        int vertices = 6;
        GraphK graph = new GraphK(vertices);
        graph.addWeightEdge(0, 1, 4);
        graph.addWeightEdge(0, 2, 3);
        graph.addWeightEdge(1, 2, 1);
        graph.addWeightEdge(1, 3, 2);
        graph.addWeightEdge(2, 3, 4);
        graph.addWeightEdge(3, 4, 2);
        graph.addWeightEdge(4, 5, 6);
        graph.doKruskal();
    }

    public static class GraphK {
        List<Edge> edges = new ArrayList<>();
        int v;

        public GraphK(int v) {
            this.v = v;
        }

        public void addWeightEdge(int weight, int source, int dest) {
            Edge edgeK = new Edge(weight, source, dest);
            edges.add(edgeK);
        }

        private int findParent(int[] parent, int vertix) {
            int parentOfVertix = parent[vertix];
            if (parentOfVertix != vertix) {
                return findParent(parent, parent[parentOfVertix]);
            }
            return parentOfVertix;
        }

        public void setParent(int[] parent) {
            for (int i = 0; i < v; i++) {
                parent[i] = i;
            }
        }

        public void union(int[] parent, int x, int y) {
            // should find parents first, but why??
//            int parent1 = findParent(parent, x);
//            int parent2 = findParent(parent, y);

            parent[x] = y;
        }

        public void doKruskal() {

            int[] parent = new int[v];
            setParent(parent);

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
            pq.addAll(edges);

            List<Edge> result = new ArrayList<>();

            int i = 0;

            //process vertices - 1 edges
            while (i < v - 1) {
                Edge poll = pq.poll();
                int parentOfSource = findParent(parent, poll.source);
                int parentOfDest = findParent(parent, poll.destination);

                if (parentOfDest == parentOfSource) {
                    // there is a cycle
                } else {
                    result.add(poll);
                    i++;
                    union(parent, parentOfDest, parentOfSource);
                }

            }
            printGraph(result);
        }

        public void printGraph(List<Edge> edgeList) {
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
            }
        }
    }
}
