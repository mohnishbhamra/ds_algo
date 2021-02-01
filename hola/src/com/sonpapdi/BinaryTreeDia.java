package com.sonpapdi;

import java.util.Vector;

/* Class to print the Diameter */
class BinaryTreeDia
{
    Node root;




    /* A wrapper over diameter(Node root) */
    int diameter()
    {



        class Local{
            Vector<Node> path= new Vector<>();
            Vector<Node> longestPath(Node root){
                longestPathUtil(root);
                return path;
            }
            Vector<Node> longestPathUtil(Node root)
            {
                Vector<Node> v1=new Vector();
                Vector<Node> v2=new Vector();
                if(root==null){
                    return v1;
                }
                v1 = longestPathUtil(root.left);
                v2 = longestPathUtil(root.right);
                if(v1.size()==0){
                    v2.add(0,root);
                    return v2;
                } else if(v2.size()==0){
                    v1.add(0,root);
                    return v1;
                } else {
                    int length = v1.size()+v2.size()+1;
                    if(length>path.size()){
                        path = new Vector<>();
                        path = (Vector<Node>) v1.clone();
                        path = reverse(path);
                        path.add(root);
                        path.addAll(v2);
                    }
                    if(v1.size()>v2.size()){
                        v1.add(0,root);
                        return v1;
                    } else {
                        v2.add(0,root);
                        return v2;
                    }
                }
            }

            private Vector<Node> reverse(Vector<Node> path) {
                Vector<Node> pathx = new Vector<>();
                for(int i=0;i<path.size();i++){
                    pathx.add(0,path.get(i));
                }
                return pathx;
            }
        }
        Vector<Node> path=new Local().longestPath(root);
        System.out.println();
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i).data+", ");
        }
        System.out.println();
        return 1;
    }

    /*The function Compute the "height" of a tree. Height is the 
    number f nodes along the longest path from the root node 
    down to the farthest leaf node.*/
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0; 

		/* If tree is not empty then height = 1 + max of left 
		height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTreeDia tree = new BinaryTreeDia();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(7);
        tree.root.left.left.left.left.right = new Node(8);
        tree.root.left.left.left.left.right.left = new Node(9);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(10);
        tree.root.left.right.right.left = new Node(11);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
    }
} 
