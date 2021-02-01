package com.graphs;
// Java program to find minimum edge
// between given two vertex of Graph

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

class MinEdgeBW2Nodes {
    // Method for finding minimum no. of edge
    // using BFS
    static int minEdgeBFS(Vector<Integer> edges[], int u,
                          int v, int n) {
        // visited[n] for keeping track of visited
        // node in BFS
        Vector<Boolean> visited = new Vector<Boolean>(n);

        for (int i = 0; i < n; i++) {
            visited.addElement(false);
        }

        // Initialize distances as 0
        Vector<Integer> distance = new Vector<Integer>(n);

        for (int i = 0; i < n; i++) {
            distance.addElement(0);
        }

        // queue to do BFS.
        Queue<Integer> Q = new LinkedList<>();
        distance.setElementAt(0, u);

        Q.add(u);
        visited.setElementAt(true, u);
        while (!Q.isEmpty()) {
            int x = Q.peek();
            Q.poll();

            for (int i = 0; i < edges[x].size(); i++) {
                if (visited.elementAt(edges[x].get(i)))
                    continue;

                // update distance for i
                distance.setElementAt(distance.get(x) + 1, edges[x].get(i));
                Q.add(edges[x].get(i));
                visited.setElementAt(true, edges[x].get(i));
            }
        }
        return distance.get(v);
    }

    // method for addition of edge
    static void addEdge(Vector<Integer> edges[], int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

    // Driver method
    public static void main(String args[]) {
        // To store adjacency list of graph
        int n = 7;
        Vector<Integer> edges[] = new Vector[n];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Vector<>();
        }

        addEdge(edges, 1, 0);
        addEdge(edges, 0, 2);
        addEdge(edges, 0, 4);
        addEdge(edges, 1, 2);
        addEdge(edges, 2, 5);
        addEdge(edges, 5, 4);
        addEdge(edges, 3, 4);
        addEdge(edges, 4, 6);

        int u = 1;
        int v = 5;
        System.out.println(minEdgeBFS(edges, u, v, n));
    }
}
// This code is contributed by Gaurav Miglani

