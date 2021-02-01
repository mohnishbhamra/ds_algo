package com.sonpapdi;


public class BinaryTreeToChildrenSumTree {


    Node root;
	/* This function changes a tree to hold children sum
	property */

    void convertTree(Node node) {
        int left_data = 0, right_data = 0, diff;

		/* If tree is empty or it's a leaf node then
		return true */
        if (node == null
                || (node.left == null && node.right == null))
            return;
        else {
            /* convert left and right subtrees */
            convertTree(node.left);
            convertTree(node.right);

			/* If left child is not present then 0 is used
			as data of left child */
            if (node.left != null)
                left_data = node.left.data;

			/* If right child is not present then 0 is used
			as data of right child */
            if (node.right != null)
                right_data = node.right.data;

            /* get the diff of node's data and children sum */
            diff = left_data + right_data - node.data;

            /* If node's children sum is greater than the node's data */
            if (diff > 0)
                node.data = node.data + diff;

			/* THIS IS TRICKY --> If node's data is greater than children
			sum, then increment subtree by diff */
            if (diff < 0)

                // -diff is used to make diff positive
                increment(node, -diff);
        }
    }

    /* This function is used to increment subtree by diff */
    void increment(Node node, int diff) {
        /* IF left child is not NULL then increment it */
        if (node.left != null) {
            node.left.data = node.left.data + diff;

            // Recursively call to fix the descendants of node->left
            increment(node.left, diff);
        } else if (node.right != null) // Else increment right child
        {
            node.right.data = node.right.data + diff;

            // Recursively call to fix the descendants of node->right
            increment(node.right, diff);
        }
    }

    /* Given a binary tree, printInorder() prints out its
    inorder traversal*/
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        BinaryTreeToChildrenSumTree tree = new BinaryTreeToChildrenSumTree();
        tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.left.left = new Node(80);
        tree.root.right.right = new Node(30);

        System.out.println("Inorder traversal before conversion is :");
        tree.printInorder(tree.root);

        tree.root = tree.changeTreeToChildrenSumTree(tree.root);
        System.out.println("");

        System.out.println("Inorder traversal after conversion is :");
        tree.printInorder(tree.root);

    }

    private Node changeTreeToChildrenSumTree(Node root) {
        if (root == null) {
            return root;
        }

        Node leftNode = root.left;
        Node rightNode = root.right;
        int leftData, rightData;
        leftData = rightData = 0;
        if (leftNode == null && rightNode == null) {
            return root;
            //leaf node, we will just return it
        }
        if (leftNode != null) {
            leftData = leftNode.data;
        }
        if (rightNode != null) {
            rightData = rightNode.data;
        }

        Node minNode = null;
        Node maxNode = null;
        if (leftData < rightData) {
            minNode = leftNode;
            maxNode = rightNode;
        } else {
            minNode = rightNode;
            maxNode = leftNode;
        }

        if (root.data > (leftData + rightData)) {
            if (minNode != null) {
                minNode.data = root.data - maxNode.data;
                if (minNode == leftNode) {
                    leftData = minNode.data;
                } else {
                    rightData = minNode.data;
                }

            } else {
                maxNode.data = root.data;
                if (maxNode == leftNode) {
                    leftData = maxNode.data;
                } else {
                    rightData = maxNode.data;
                }
            }

        } else if (root.data < (leftData + rightData)) {
            root.data = leftData + rightData;
        }

        leftNode = changeTreeToChildrenSumTree(root.left);
        if (leftNode != null && leftData != leftNode.data) {
            int diff = leftNode.data - leftData;
            root.data += diff;
/*            if (root.right != null) {
                root.right.data += diff;
            }*/

        }
        rightNode = changeTreeToChildrenSumTree(root.right);
        if (rightNode != null && rightData != rightNode.data) {
            int diff = rightNode.data - rightData;
            root.data += diff;
           /* if (root.left != null) {
                root.left.data += diff;
            }*/

        }
        return root;
    }
}

// This code has been contributed by Mayank Jaiswal(mayank_24)

