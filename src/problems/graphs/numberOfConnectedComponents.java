package problems.graphs;

public class numberOfConnectedComponents {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
        findNumDisconnected(n, edges);
    }
    // O(VE)
    private static int findNumDisconnected(int n, int[][] edges) {
        int[] parent = new int[n];

        for (int i = 0 ;i < n; i++) {
            parent[i] = i;
        }
        int count = n;
        for (int[] edge: edges){
            int parent1 = findParent(parent, edge[0]);
            int parent2 = findParent(parent, edge[1]);

            if (parent1 == parent2) {
                //theres a cycle
            } else {
                count--;
                doUnion(parent, parent1,parent2);
            }
        }

        return count;
    }

    private static void doUnion(int[] parent, int parent1, int parent2) {
        if (parent1 < parent2) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }

    }

    private static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            return findParent(parent, parent[x]);
        }
        return x;
    }
}