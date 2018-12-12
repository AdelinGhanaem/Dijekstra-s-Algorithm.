package com.dijkstra;

import java.util.*;

public class Vertex<T> {


    private T data;

    //represents a shortest predecessor distance from it's adjacenct edge
    private int distance = Integer.MAX_VALUE;
    /**
     * Represents A vertex and it's distance form current vertex.
     */
    private Map<Vertex<T>, Integer> adjacents = new HashMap<>();
    /**
     * when we traverse adjacents we start from the one that is less distance fron the current this is why we need to keep adjacent vertexes
     * in a sorted structure according to their distance from current vertex this priority queue sorts values coparing them to they distaces from the currecnt vertex
     * i.e adjacents.get(data)
     */
    private PriorityQueue<Vertex<T>> sortedByDistanceValue = new PriorityQueue<>(Comparator.comparing(data -> adjacents.get(data)));


    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getDistance() {
        return distance;
    }


    public void setDistance(int distance) {
        this.distance = distance;
    }


    public void addAdjacentGraph(int distance, Vertex<T> adjacentVertex) {
        adjacents.put(adjacentVertex, distance);
        sortedByDistanceValue.add(adjacentVertex);

    }


    public PriorityQueue<Vertex<T>> getAdjacents() {
        return new PriorityQueue<>(sortedByDistanceValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public Integer distanceTo(Vertex<T> adjacent) {
        return adjacents.get(adjacent);
    }


    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                '}';
    }
}
