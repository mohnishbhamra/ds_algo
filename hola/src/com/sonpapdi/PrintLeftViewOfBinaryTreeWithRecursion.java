package com.sonpapdi;

public class PrintLeftViewOfBinaryTreeWithRecursion {
    Node root;
    static int max_level = 0;

    // recursive function to print left view
    void leftViewUtil(Node node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView() {
        leftViewUtil(root, 1);
    }
    void leftViewRecursive(Node root,Node hasLeftNode) {

        if(root==null){
            return;
        }
        if(hasLeftNode==null){
            System.out.print(root.data+" ");
        }

        leftViewRecursive(root.left,null);
        leftViewRecursive(root.right,root.left);
    }
    /* testing for example nodes */
    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        PrintLeftViewOfBinaryTreeWithRecursion tree = new PrintLeftViewOfBinaryTreeWithRecursion();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftView();
        System.out.println();
        tree.leftViewRecursive(tree.root,null);
    }
}

