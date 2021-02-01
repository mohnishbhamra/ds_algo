package com.sonpapdi;

import java.util.Vector;

public class BinaryTreeAtKUnitFromTargetNode {
    Node root;
	/* Recursive function to print all the nodes at distance k in
	tree (or subtree) rooted with given root. */

    void printkdistanceNodeDown(Node node, int k) {
        // Base Case
        if (node == null || k < 0)
            return;

        // If we reach a k distant node, print it
        if (k == 0) {
            System.out.print(node.data);
            System.out.println("");
            return;
        }

        // Recur for left and right subtrees
        printkdistanceNodeDown(node.left, k - 1);
        printkdistanceNodeDown(node.right, k - 1);
    }

    // Prints all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.This function
    // Returns distance of root from target node, it returns -1
    // if target node is not present in tree rooted with root.
    int printkdistanceNode(Node node, Node target, int k) {
        // Base Case 1: If tree is empty, return -1
        if (node == null)
            return -1;

        // If target is same as root. Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (node == target) {
            printkdistanceNodeDown(node, k);
            return 0;
        }

        // Recur for left subtree
        int dl = printkdistanceNode(node.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1) {

            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
            if (dl + 1 == k) {
                System.out.print(node.data);
                System.out.println("");
            }

            // Else go to right subtree and print all k-dl-2 distant nodes
            // Note that the right child is 2 edges away from left child
            else
                printkdistanceNodeDown(node.right, k - dl - 2);

            // Add 1 to the distance and return value for parent calls
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left
        // subtree
        int dr = printkdistanceNode(node.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.print(node.data);
                System.out.println("");
            } else
                printkdistanceNodeDown(node.left, k - dr - 2);
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }

    Vector<Node> vector = new Vector<>();

    boolean fillVector(Node root, Node target) {
        boolean shouldFillMore = true;
        if (root == null) {
            //vector.remove(vector.size()-1);
            return shouldFillMore;
        }
        vector.add(root);
        if (root == target) {
            shouldFillMore = false;
            return shouldFillMore;
        }
        int size = vector.size();
        shouldFillMore = fillVector(root.left, target);
        if (shouldFillMore) {
            int rem = vector.size() - size;
            for (; rem > 0; rem--) {
                vector.remove(vector.size() - 1);
            }
            shouldFillMore = fillVector(root.right, target);
        }

        return shouldFillMore;
    }

    Vector<Node> mapThatHasBeenPrinted = new Vector<>();

    void printAt(Node root, int initialDistance, int finalDistance) {

        if (root == null || initialDistance>finalDistance) {
            return;
        }
        if (initialDistance == finalDistance && !mapThatHasBeenPrinted.contains(root)) {
            mapThatHasBeenPrinted.add(root);
            System.out.print(root.data + ",");
            return;
        }
        printAt(root.left, initialDistance + 1, finalDistance);
        printAt(root.right, initialDistance + 1, finalDistance);
        return;
    }

    void printkdistanceNodeCustom(Node root, Node target, int k) {
        System.out.println("path to target from node is");
        if (k == 0) {
            System.out.println("now nodes which are at " + k + " units away from target " + target.data + " is traget itself.");
            return;
        }
        fillVector(root, target);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i).data + "-> ");
        }
        System.out.println("now nodes which are at " + k + " units away from target " + target.data + " are:");
        mapThatHasBeenPrinted.add(target);
        Node node = vector.remove(vector.size() - 1);
        printAt(node, 0, k);
        if (vector.size() >= k) {
            Node temp = vector.get(vector.size() - k);
            mapThatHasBeenPrinted.add(temp);
            System.out.print(temp.data + ",");
        }
        int offset = 2;
        while (offset <= k && !vector.isEmpty()) {
            Node newnode = vector.remove(vector.size() - 1);
            if (newnode.left == node) {
                node = newnode;
                newnode = newnode.right;
            } else {
                node = newnode;
                newnode = newnode.left;
            }

            printAt(newnode, offset, k);
            offset++;

        }
    }















    // Driver program to test the above functions
    public static void main(String args[]) {
        BinaryTreeAtKUnitFromTargetNode tree = new BinaryTreeAtKUnitFromTargetNode();

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(14);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printkdistanceNodeCustom(tree.root, target, 3);
    }

    private void printkdistanceNodeCustom2(Node root, Node target, int k,int i) {
        if(root==null){
            return;
        }
        if(root==target){
            return ;
        }
    }
}


