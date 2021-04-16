package model;

import java.util.ArrayList;
import java.util.List;

public class GraphWeight {

    public int v;
    public List<List<Edge>> adjList;

    public GraphWeight(int v) {
        this.v = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i ++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdgeWEight(int source, int dest, int weight) {
        adjList.get(source).add(new Edge(source, dest, weight));
        adjList.get(dest).add(new Edge(source,dest,weight));
    }
}
