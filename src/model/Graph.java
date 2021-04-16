package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int v;
    private List<List<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>();
        for (int i = 0; i < v ; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int x, int y) {
        adj.get(x).add(y);
    }

    public int getV() {
        return v;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }
}
