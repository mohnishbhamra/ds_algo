package com.sonpapdi;
import java.util.HashMap;
import java.util.Map;

public class LCAusingParentPointer {
    class Node
    {
        int data;
        Node left, right, parent;//see we have a parent pointer

        Node(int key)
        {
            this.data = key;
            left = right = parent = null;
        }
    }
    Node root, n1, n2, lca;

    /* A utility function to insert a new node with
    given data in Binary Search Tree */
    Node insert(Node node, int key)
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.data)
        {
            node.left = insert(node.left, key);
            node.left.parent = node;
        }
        else if (key > node.data)
        {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // To find LCA of nodes n1 and n2 in Binary Tree
    Node LCA(Node n1, Node n2)
    {
        // Creata a map to store ancestors of n1
        Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>();

        // Insert n1 and all its ancestors in map
        while (n1 != null)
        {
            ancestors.put(n1, Boolean.TRUE);
            n1 = n1.parent;
        }

        // Check if n2 or any of its ancestors is in
        // map.
        while (n2 != null)
        {
            if (ancestors.containsKey(n2) != ancestors.isEmpty())
                return n2;
            n2 = n2.parent;
        }

        return null;
    }

    // Driver method to test above functions
    public static void main(String[] args)
    {
        LCAusingParentPointer tree = new LCAusingParentPointer();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root.left;
        tree.lca = tree.LCA(tree.n1, tree.n2);

        System.out.println("LCA of " + tree.n1.data + " and " + tree.n2.data
                + " is " + tree.lca.data);
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)
