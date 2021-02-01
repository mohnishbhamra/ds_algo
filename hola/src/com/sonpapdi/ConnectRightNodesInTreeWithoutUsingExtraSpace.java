package com.sonpapdi;

public class ConnectRightNodesInTreeWithoutUsingExtraSpace {
// Recursive Java program to connect nodes at same level
// using constant extra space

    // A binary tree node
    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }

        public String toString() {
            return this.data + "";
        }
    }


    Node root;

    /* Set next right of all descendents of root. This function makes sure that
    nextRight of nodes ar level i is set before level i+1 nodes. */
    void connectRecur(Node root) {
        // Base case
        if (root == null)
            return;

		/* Before setting nextRight of left and right children, set nextRight
		of children of other nodes at same level (because we can access
		children of other nodes using root's nextRight only) */
        if (root.nextRight != null)
            connectRecur(root.nextRight);

        /* Set the nextRight pointer for root's left child */
        if (root.left != null) {
            if (root.right != null) {
                root.left.nextRight = root.right;
                root.right.nextRight = getNextRight(root);
            } else
                root.left.nextRight = getNextRight(root);

			/* Recursively call for next level nodes. Note that we call only
			for left child. The call for left child will call for right child */
            connectRecur(root.left);
        }

		/* If left child is NULL then first node of next level will either be
		root->right or getNextRight(root) */
        else if (root.right != null) {
            root.right.nextRight = getNextRight(root);
            connectRecur(root.right);
        } else
            connectRecur(getNextRight(root));
    }

    /* This function returns the leftmost child of nodes at the same
    level as root. This function is used to getNExt right of root's right child
    If right child of root is NULL then this can also be used for
    the left child */
    Node getNextRight(Node root) {
        Node temp = root.nextRight;

		/* Traverse nodes at root's level and find and return
		the first node's first child */
        while (temp != null) {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.nextRight;
        }

        // If all the nodes at root's level are leaf nodes then return NULL
        return null;
    }

    /* Driver program to test the above functions */
    public static void main(String args[]) {
        ConnectRightNodesInTreeWithoutUsingExtraSpace tree = new ConnectRightNodesInTreeWithoutUsingExtraSpace();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.left.left = new Node(7);
        tree.root.right.right = new Node(90);
        tree.root.right.right.left = new Node(9);

        // Populates nextRight pointer in all nodes
        //tree.connectRecur(tree.root);
        tree.connectRecur(tree.root);
        validate(tree.root);
    }

    private static void validate(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root + " -> " + root.nextRight);
        validate(root.left);
        validate(root.right);
    }

    private void connectRecur2(Node root, Node parent) {
        if (root == null) {
            return;
        }

        //if(root.left==null && root.right == null)
        if (root.left != null && root.right != null) {
            root.left.nextRight = root.right;
            root.right.nextRight = root.nextRight;
        } else if (root.right == null && root.left != null) {
            root.left.nextRight = root.nextRight;
        } else if (root.left == null && root.right != null) {
            root.right.nextRight = root.nextRight;
        }


        connectRecur2(root.left, root);
        connectRecur2(root.right, root);


        Node daignol = root.nextRight;

        if (shouldCalculateRight(root, parent) == true && daignol != null) {
            int height = 1;


            while (daignol != null) {
                if (daignol.left != null || daignol.right != null) {
                    break;
                } else if (daignol.left == null && daignol.right == null) {
                    daignol = daignol.nextRight;
                    height++;
                }
            }

            if (daignol != null) {
                root.nextRight = getLeftestNode(daignol, height);
            }
        }
    }

    private boolean shouldCalculateRight(Node root, Node parent) {
        if (parent == null) {
            return false;
        }//1 time case

        if (parent.left == root && parent.right != null) {
            return false;
        }

        return true;
    }

    private Node getLeftestNode(Node node, int height) {
        if (node == null) {
            return null;
        }
        if (height == 0) {
            return node;
        }
        Node returnval = getLeftestNode(node.left, height - 1);
        if (returnval == null) {
            returnval = getLeftestNode(node.right, height - 1);
        }
        return returnval;
    }
}

// This code has been contributed by Mayank Jaiswal
//mod by  msb as new function

