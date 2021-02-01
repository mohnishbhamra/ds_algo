package com.graphs;

//JAVA Code For DFS for a n-ary tree (acyclic graph)
// represented as adjacency list

import java.util.*;

class DFS {

    // DFS on tree
    public static void dfs(LinkedList<Integer> list[],
                           int node, int arrival) {
        // Printing traversed node
        System.out.println(node);

        // Traversing adjacent edges
        for (int i = 0; i < list[node].size(); i++) {

            // Not traversing the parent node
            if (list[node].get(i) != arrival)
                dfs(list, list[node].get(i), node);
        }
    }

    /* Driver program to test above function */
    public static void main(String[] args) {

        // Number of nodes
        int nodes = 5;

        // Adjacency list
        LinkedList<Integer> list[] = new LinkedList[nodes + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<Integer>();
        }

        // Designing the tree
        list[1].add(2);
        list[2].add(1);

        list[1].add(3);
        list[3].add(1);

        list[2].add(4);
        list[4].add(2);

        list[3].add(5);
        list[5].add(3);

        // Function call
        dfs(list, 1, 0);


    }
}
// This code is contributed by Arnav Kr. Mandal.
