package com.sonpapdi;

//Java program to create a doubly linked list
// from a given ternary tree.

//Custom node class.
class newNode {
    int data;
    newNode left, middle, right;

    public newNode(int data) {
        this.data = data;
        left = middle = right = null;
    }
}

class GFG {

    //tail of the linked list.
    static newNode tail;

    //function to push the node to the tail.
    public static void push(newNode node) {
        //to put the node at the end of
        // the already existing tail.
        tail.right = node;

        //to point to the previous node.
        node.left = tail;

        // middle pointer should point to
        // nothing so null. initiate right
        // pointer to null.
        node.middle = node.right = null;

        //update the tail position.
        tail = node;
    }

    /* Create a doubly linked list out of given a ternary tree.
    by traversing the tree in preoder fashion. */
    public static void ternaryTree(newNode node, newNode head) {
        if (node == null)
            return;
        newNode left = node.left;
        newNode middle = node.middle;
        newNode right = node.right;
        if (tail != node)

            // already root is in the tail so dont push
            // the node when it was root.In the first
            // case both node and tail have root in them.
            push(node);

        // First the left child is to be taken.
        // Then middle and then right child.
        ternaryTree(left, head);
        ternaryTree(middle, head);
        ternaryTree(right, head);
    }

    //function to initiate the list process.
    public static newNode startTree2(newNode root) {
        //Initiate the head and tail with root.
        newNode head = root;
        tail = root;
        ternaryTree(root, head);

        //since the head,root are passed
        // with reference the changes in
        // root will be reflected in head.
        return head;
    }
    public static newNode startTree(newNode root,newNode parent) {
        if(root==null){
         return root;
        }
        newNode rightMost = root;
        newNode right = rightMost.right;
        newNode left = startTree(root.left,root);
        boolean isLeftNull,isMidNull,isRighttNull;
        isLeftNull=isMidNull=isRighttNull =true;
        if(left!=null){
            isLeftNull = false;
            left.left=rightMost; //back connection\
            root.right=left;
            while(left.right!=null){
                left=left.right;
            }
            rightMost=left;
        }
        newNode mid = startTree(root.middle,root);
        if(mid!=null){
            isMidNull = false;
            mid.left=rightMost;
            rightMost.right=mid;
            while(mid.right!=null){
                mid=mid.right;
            }
            rightMost=mid;
        }
        root.middle=null;
        right= startTree(right,root);
        if(right!=null){
            isRighttNull =false;
            right.left=rightMost;
            rightMost.right=right;
        }

        if(isLeftNull && isMidNull && isRighttNull){
            //leaf node
            System.out.println(root.data+"is a leaf node");
        } else {
            root.left=parent;
        }
        return root;
    }

    // Utility function for printing double linked list.
    public static newNode printList(newNode head) {
        System.out.print("Created Double Linked list is:\n");

        while (head.right != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.print(head.data + " ");
        return head;
    }
    public static void printList2(newNode head) {
        System.out.print("Created Linked list is:\n");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.left;
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {

        // Construting ternary tree as shown
        // in above figure
        newNode root = new newNode(30);
        root.left = new newNode(5);
        root.middle = new newNode(11);
        root.right = new newNode(63);
        root.left.left = new newNode(1);
        root.left.middle = new newNode(4);
        root.left.right = new newNode(8);
        root.middle.left = new newNode(6);
        root.middle.middle = new newNode(7);
        root.middle.right = new newNode(15);
        root.right.left = new newNode(31);
        root.right.middle = new newNode(55);
        root.right.right = new newNode(65);

        // The function which initiates the list
        // process returns the head.
        newNode head = startTree(root,null);
        newNode last = printList(head);
        printList2(last);
    }
}
