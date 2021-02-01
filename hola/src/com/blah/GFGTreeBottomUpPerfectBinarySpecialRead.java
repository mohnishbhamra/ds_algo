package com.blah;

import java.util.*;

public class GFGTreeBottomUpPerfectBinarySpecialRead {

    /* A binary tree node has data,
    pointer to left child and
    a pointer to right child */
    static class Node {
        int data;
        Node left;
        Node right;

        /* Helper function that allocates
        a new node with the given data and
        null left and right pointers. */
        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    ;

    /* Given a perfect binary tree,
    print its nodes in specific level order */
    static void specific_level_order_traversal(Node root) {
        // for level order traversal
        Queue<Node> queue = new LinkedList<>();

        // Stack to print reverse
        Stack<Vector<Integer>> s = new Stack<Vector<Integer>>();

        queue.add(root);
        int sz;

        while (queue.size() > 0) {
            // vector to store the level
            Vector<Integer> vector = new Vector<Integer>();
            sz = queue.size(); // considering size of the level

            for (int i = 0; i < sz; ++i) {
                Node node = queue.peek();
                queue.remove();

                // push data of the node of a
                // particular level to vector
                vector.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            // push vector containg a level in Stack
            s.push(vector);
        }

        // print the Stack
        while (s.size() > 0) {
            // Finally pop all Nodes from Stack
            // and prints them.
            Vector<Integer> v = s.peek();
            s.pop();
            for (int i = 0, j = v.size() - 1; i < j; ++i,j--) {
                System.out.print(v.get(i) + " " + v.get(j) + " ");

            }
            System.out.println();
        }

        // finally print root;
        System.out.println(root.data);

    }

    // Driver code
    public static void main(String args[]) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        root.left.left.left.left = new Node(16);
        root.left.left.left.right = new Node(17);
        root.left.left.right.left = new Node(18);
        root.left.left.right.right = new Node(19);
        root.left.right.left.left = new Node(20);
        root.left.right.left.right = new Node(21);
        root.left.right.right.left = new Node(22);
        root.left.right.right.right = new Node(23);
        root.right.left.left.left = new Node(24);
        root.right.left.left.right = new Node(25);
        root.right.left.right.left = new Node(26);
        root.right.left.right.right = new Node(27);
        root.right.right.left.left = new Node(28);
        root.right.right.left.right = new Node(29);
        root.right.right.right.left = new Node(30);
        root.right.right.right.right = new Node(31);
        System.out.println("Specific Level Order traversal" +
                " of binary tree is");
        specific_level_order_traversal(root);
    }
}

