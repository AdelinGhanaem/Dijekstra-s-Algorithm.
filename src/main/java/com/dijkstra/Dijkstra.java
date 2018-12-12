package com.dijkstra;

import java.util.*;

public class Dijkstra {


    public static <T extends Comparable<T>> void getShortestPathMapping(Vertex<T> source) {


        Queue<Vertex<T>> unknown = new ArrayDeque<>();

        Map<T, Integer> shortestPaths = new HashMap<>();

        shortestPaths.put(source.getData(), 0);

        unknown.add(source);

        Set<T> visited = new HashSet<>();

        while (!unknown.isEmpty()) {

            printPriorityQueue(unknown);
            Vertex<T> current = unknown.poll();

            if (!visited.contains(current.getData())) {
                // if the vertex is visited it means that we know the shortest path to it because we would have arrived here by the shortest path ever and thus we won't need to check the visited vertex  again.


                PriorityQueue<Vertex<T>> adjacentVertices = current.getAdjacents();

                System.out.println("Current:" + current.getData());

                visited.add(current.getData());

                printPriorityQueue(adjacentVertices);

                while (!adjacentVertices.isEmpty()) {
                    Vertex<T> adjacent = adjacentVertices.poll();
                    Integer pathOfAdjacent = shortestPaths.get(adjacent.getData());
                    Integer distanceOfCurrent = shortestPaths.get(current.getData());
//                System.out.println("Adjacent Data " + adjacent.getData() + ", path Of Adjacent:" + pathOfAdjacent + ", distance Of Current " + distanceOfCurrent + ", Distance and current: " + (distanceOfCurrent + current.distanceTo(adjacent)));
                    if (pathOfAdjacent == null) {// unknown
                        shortestPaths.put(adjacent.getData(), distanceOfCurrent + current.distanceTo(adjacent));
                        System.out.println("Set new Value");

                    } else { // it is know
                        if (pathOfAdjacent > distanceOfCurrent + current.distanceTo(adjacent)) {
                            shortestPaths.put(adjacent.getData(), distanceOfCurrent + current.distanceTo(adjacent));
                            System.out.println("Value Change ");
                        }
                    }
                    unknown.add(adjacent);
                }
            }

        }


        shortestPaths.forEach((k, v) -> {
            System.out.println(k + " ->" + v);
        });


    }

    private static void printPriorityQueue(Queue unknown) {
        System.out.print(" << [ ");
        unknown.forEach(v -> {
            System.out.print(v + ", ");
        });
        System.out.print("] <<");
        System.out.println();
    }


}
