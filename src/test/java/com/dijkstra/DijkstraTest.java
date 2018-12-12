package com.dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.dijkstra.Dijkstra.getShortestPathMapping;

class DijkstraTest {


    Vertex<String> v1 = new Vertex<>("v1");

    Vertex<String> v2 = new Vertex<>("v2");

    Vertex<String> v3 = new Vertex<>("v3");

    Vertex<String> v4 = new Vertex<>("v4");

    Vertex<String> v5 = new Vertex<>("v5");

    Vertex<String> v6 = new Vertex<>("v6");

    Vertex<String> v7 = new Vertex<>("v7");


    @BeforeEach
    void setUp() {

        v1.addAdjacentGraph(1, v4);
        v1.addAdjacentGraph(2, v2);

        v2.addAdjacentGraph(3, v4);
        v2.addAdjacentGraph(10, v5);

        v3.addAdjacentGraph(4, v1);
        v3.addAdjacentGraph(5, v5);

        v4.addAdjacentGraph(8, v6);
        v4.addAdjacentGraph(4, v7);
        v4.addAdjacentGraph(2, v5);

        v5.addAdjacentGraph(6, v7);

        //v6.addAdjacentGraph();

        v7.addAdjacentGraph(1, v6);
    }

    @Test
    void shortestPath() {
        getShortestPathMapping(v1);
    }
}