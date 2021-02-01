package com.sonpapdi;

import java.util.*;


public class BST_CreationLinearTimeIterative {
// Java program to construct BST from given preorder traversal
    // A binary tree node

    // The main function that constructs BST from pre[]
    Node constructTree(int pre[], int size) {

        // The first element of pre[] is always root
        Node root = new Node(pre[0]);

        Stack<Node> stack = new Stack<Node>();

        // Push root
        stack.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i) {
            Node tempNode = null;

			/* Keep on popping while the next value is greater than
			stack'stack top value. */
            while (!stack.isEmpty() && pre[i] > stack.peek().data) {
                tempNode = stack.pop();
            }

            // Make this greater value as the right child
            // and push it to the stack
            if (tempNode != null) {
                tempNode.right = new Node(pre[i]);
                stack.push(tempNode.right);
            }

            // If the next value is less than the stack'stack top
            // value, make this value as the left child of the
            // stack'stack top node. Push the new node to stack
            else {
                tempNode = stack.peek();
                tempNode.left = new Node(pre[i]);
                stack.push(tempNode.left);
            }
        }

        return root;
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BST_CreationLinearTimeIterative tree = new BST_CreationLinearTimeIterative();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}

// This code has been contributed by Mayank Jaiswal

