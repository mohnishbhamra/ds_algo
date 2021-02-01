package com.graphs;
// Java program to count all paths from a source
// to a destination.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using
// adjacency list representation

class Backtraking {

    // No. of vertices
    private int V;

    // Array of lists for
    // Adjacency List
    // Representation
    private LinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    Backtraking(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    // Method to add an edge into the graph
    void addEdge(int v, int w) {

        // Add w to v's list.
        adjacencyList[v].add(w);
    }

    // A recursive method to count
    // all paths from 'u' to 'd'.
    int countPathsUtil(int u, int d,
                       int pathCount) {

        // If current vertex is same as
        // destination, then increment count
        if (u == d) {
            pathCount++;
        }

        // Recur for all the vertices
        // adjacent to this vertex
        else {
            Iterator<Integer> i = adjacencyList[u].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                pathCount = countPathsUtil(n, d, pathCount);
            }
        }
        return pathCount;
    }

    // Returns count of
    // paths from 's' to 'd'
    int countPaths(int s, int d) {

        // Call the recursive method
        // to count all paths
        int pathCount = 0;
        pathCount = countPathsUtil(s, d,
                pathCount);
        return pathCount;
    }

    // Driver Code
    public static void main(String args[]) {
        Backtraking graphForDemoBacktracking = new Backtraking(5);
        graphForDemoBacktracking.addEdge(0, 1);
        graphForDemoBacktracking.addEdge(0, 2);
        graphForDemoBacktracking.addEdge(0, 3);
        graphForDemoBacktracking.addEdge(1, 3);
        graphForDemoBacktracking.addEdge(2, 3);
        graphForDemoBacktracking.addEdge(1, 4);
        graphForDemoBacktracking.addEdge(2, 4);
        graphForDemoBacktracking.addEdge(4, 3);

        int s = 0, d = 3;
        System.out.println(graphForDemoBacktracking.countPaths2(s, d));
    }

    private boolean countPaths2(Integer source, Integer destination) {
        if (adjacencyList[source].size() == 0) {
            return false;
        }
        ArrayList ans = new ArrayList();
        ans.add(source);
        helperFun(source,destination,ans);
        return true;
    }

    void helperFun(Integer source, Integer destination, ArrayList ans) {
        if (adjacencyList[source].size() == 0) {
            return;
        }

        ArrayList<Integer> visited = new ArrayList<>(adjacencyList[source].size());
        Iterator<Integer> iterator = adjacencyList[source].iterator();
        while (iterator.hasNext()) {
            visited.add(iterator.next()); //copying adjacent nodes
        }

        if (adjacencyList[source].contains(destination)) {
            System.out.println("present " + ans.toString() + "," + destination);
            visited.remove(destination);
        }

        iterator = visited.iterator();
        while (iterator.hasNext()) {
            Integer intermediate = iterator.next();
            ans.add(intermediate);
            helperFun(intermediate, destination, ans);
            ans.remove(intermediate);
        }

        return;
    }
}

// This code is contributed by shubhamjd.

