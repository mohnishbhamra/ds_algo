package com.graphs;


import java.io.*;
import java.util.*;

public class CountNumberOfTreesInAForest {

// Java program to count number of trees in a forest.

// This class represents a directed graph using adjacency list
// representation


    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<LinkedList<Integer>> adjacentList;

    // Constructor
    private CountNumberOfTreesInAForest(int v) {
        V = v;
        adjacentList = new LinkedList<>();
        for (int i = 0; i < V; ++i)
            adjacentList.add(new LinkedList<Integer>());
    }

    //Function to add an edge into the graph
    private void addEdge(int v, int w) {
        adjacentList.get(v).add(w); // Add w to v's list.
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    private int countTrees() {
        int answer = 0;
        int arrSet[] = new int[V];
        //initially all are parent since we haven't read any relation
        for (int index = 0; index < V; index++) {
            arrSet[index] = -1;
        }

        //now, read edges
        for (int index = 0; index < V; index++) {
            Integer source = index;
            Integer absoluteParentSource = getAbsoluteParent(source, arrSet);
            List<Integer> innerList = adjacentList.get(index);
            for (int jIndex = 0; jIndex < innerList.size(); jIndex++) {
                Integer destination = innerList.get(jIndex);
                Integer absoluteParentDestination = getAbsoluteParent(destination, arrSet);
                arrSet[absoluteParentDestination] = absoluteParentSource;
            }
        }

        //after making relation, read how many -1s or absoluteParent are present & return the value

        for (int index = 0; index < V; index++) {
            if (arrSet[index] == -1) {
                answer++;
            }
        }
        return answer;
    }

    private Integer getAbsoluteParent(Integer value, int[] arrSet) {
        Integer val = arrSet[value];
        if (val == -1) {
            return value;
        }

        val = getAbsoluteParent(val, arrSet);

        return val;
    }

    // Driver code
    public static void main(String args[]) {
        CountNumberOfTreesInAForest graph = new CountNumberOfTreesInAForest(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 4);
        System.out.println(graph.countTrees());
    }
}

//Solution by Mohnish S Bhamra
