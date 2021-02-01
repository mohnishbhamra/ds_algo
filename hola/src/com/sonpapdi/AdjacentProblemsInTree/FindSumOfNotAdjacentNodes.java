package com.sonpapdi.AdjacentProblemsInTree;

// Java program to find maximum sum from a subset of
// nodes of binary tree
import java.util.HashMap;
public class FindSumOfNotAdjacentNodes {

    // method returns maximum sum possible from subtrees rooted
    // at grandChildrens of node 'node'
    public static int sumOfGrandChildren(Node node, HashMap<Node,Integer> map)
    {
        int sum = 0;
        // call for children of left child only if it is not NULL
        if (node.left!=null)
            sum += getMaxSumUtil(node.left.left, map) +
                    getMaxSumUtil(node.left.right, map);

        // call for children of right child only if it is not NULL
        if (node.right!=null)
            sum += getMaxSumUtil(node.right.left, map) +
                    getMaxSumUtil(node.right.right, map);
        return sum;
    }

    // Utility method to return maximum sum rooted at node 'node'
    public static int getMaxSumUtil(Node node, HashMap<Node,Integer> map)
    {
        if (node == null)
            return 0;

        // If node is already processed then return calculated
        // value from map
        if(map.containsKey(node))
            return map.get(node);

        // take current node value and call for all grand children
        int incl = node.data + sumOfGrandChildren(node, map);

        // don't take current node value and call for all children
        int excl = getMaxSumUtil(node.left, map) +
                getMaxSumUtil(node.right, map);

        // choose maximum from both above calls and store that in map
        map.put(node,Math.max(incl, excl));

        return map.get(node);
    }

    // Returns maximum sum from subset of nodes
    // of binary tree under given constraints
    public static int getMaxSum(Node node)
    {
        if (node == null)
            return 0;
        HashMap<Node,Integer> mp=new HashMap<>();
        return getMaxSumUtil(node, mp);
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        System.out.print(getMaxSum(root));
    }
}

/* A binary tree node structure */
class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
};
//This code is contributed by Gaurav Tiwari
