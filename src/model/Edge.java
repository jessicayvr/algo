package model;

public class Edge {
    public int weight;
    public int source;
    public int destination;

    public Edge(int source, int destination, int weight) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }
}

