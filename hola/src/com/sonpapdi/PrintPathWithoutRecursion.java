package com.sonpapdi;


// Java program to Print root to leaf path WITHOUT
// using recursion

import java.util.Stack;
import java.util.HashMap;
import java.util.Vector;

public class PrintPathWithoutRecursion {

    /* Function to print root to leaf path for a leaf
    using parent nodes stored in map */
    public static void printTopToBottomPath(Node curr, HashMap<Node, Node> parent) {
        Stack<Node> stack = new Stack<>();

        // start from leaf node and keep on pushing
        // nodes into stack till root node is reached
        while (curr != null) {
            stack.push(curr);
            curr = parent.get(curr);
        }

        // Start popping nodes from stack and print them
        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr.data + " ");
        }
        System.out.println();
    }


    /* An iterative function to do preorder traversal
    of binary tree and print root to leaf path
    without using recursion */
    public static void printRootToLeaf(Node root) {
        // Corner Case
        if (root == null)
            return;

        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // Create a map to store map pointers of binary
        // tree nodes
        HashMap<Node, Node> map = new HashMap<>();

        // map of root is NULL
        map.put(root, null);

		/* Pop all items one by one. Do following for
		every popped item
			a) push its right child and set its map
			pointer
			b) push its left child and set its map
			pointer
		Note that right child is pushed first so that
		left is processed first */
        while (!stack.isEmpty()) {
            // Pop the top item from stack
            Node node = stack.pop();

            // If leaf node encountered, print Top To
            // Bottom path
            if (node.left == null && node.right == null)
                printTopToBottomPath(node, map);

            // Push right & left children of the popped node
            // to stack. Also set their map pointer in
            // the map
            if (node.right != null) {
                map.put(node.right, node);
                stack.push(node.right);
            }
            if (node.left != null) {
                map.put(node.left, node);
                stack.push(node.left);
            }
        }
    }

    public static void printRootToLeaf2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Vector<Node> vector = new Vector();
        Node node = root;
        stack.push(root);
        vector.add(root);
        /*while (node.left != null) {
            node = node.left;
            stack.push(node);
            vector.add(node);
        }*/

        while (stack.isEmpty() != true) {
            node = stack.peek();

            while (node.left != null) {
                //fill all left
                node = node.left;
                stack.push(node);
                vector.add(node);
            }

            if (node.right != null) {
                stack.add(node.right);
                vector.add(node.right);
            } else {
                System.out.println();
                int i = 0;
                for (; i < vector.size(); i++) {
                    System.out.print(vector.get(i).data + " ");
                }
                vector.remove(vector.size() - 1);
                stack.pop();
                while (stack.isEmpty() != true) {
                    node = stack.pop();
                    if (node.right == null) {
                        int x = 0;
                        for (; x < vector.size(); x++) {
                            if (vector.get(0) == node) {
                                break;
                            }
                        }
                        int elementsToBeRemoved = vector.size() - x;
                        for (; elementsToBeRemoved > 0; elementsToBeRemoved--) {
                            vector.remove(vector.size() - 1);
                        }

                    } else {
                        stack.push(node.right);
                        vector.add(node.right);
                        break;
                    }
                }
            }
        }
    }


    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        printRootToLeaf2(root);
    }
}
