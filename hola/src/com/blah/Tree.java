package com.blah;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public int data;
    Tree left, right;

    public Tree(int data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Tree() {
    }

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public static void insertComplete(Tree root, int data) {
        if (root == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        while (queue.isEmpty() != true) {
            Tree node = ((LinkedList<Tree>) queue).pop();
            if (node.left == null) {
                node.left = new Tree(data);
                return;
            } else {
                ((LinkedList<Tree>) queue).add(node.left);
            }
            if (node.right == null) {
                node.right = new Tree(data);
                return;
            } else {
                ((LinkedList<Tree>) queue).add(node.right);
            }
        }
        return;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public static void printLevelOrder(Tree root) {
        if (root == null) {
            return;
        }
        System.out.println("Level order for the tree is :");

        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while (queue.isEmpty() != true) {
            Tree node = ((LinkedList<Tree>) queue).remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
                ((LinkedList<Tree>) queue).add(node.left);
            }
            if (node.right != null) {
                ((LinkedList<Tree>) queue).add(node.right);
            }
        }
        return;
    }

    public static void printZigZac(Tree root) {
        if (root == null) {
            return;
        }
        System.out.println("Zig-Zac order for the tree is :");
        int level = 1;
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while (queue.isEmpty() != true) {
            //System.out.println("level=" + level);
            if (level % 2 != 0) {
                Queue<Tree> tempQueue = new LinkedList<Tree>();
                while (queue.isEmpty() != true) {
                    Tree node = queue.remove();
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        tempQueue.add(node.left);
                    }
                    if (node.right != null) {
                        tempQueue.add(node.right);
                    }

                }
                queue = tempQueue;
            } else {
                Queue<Tree> tempQueue = new LinkedList<Tree>();
                while (queue.isEmpty() != true) {
                    Tree node = ((LinkedList<Tree>) queue).removeLast();
                    System.out.print(node.data + " ");

                    if (node.right != null) {
                        ((LinkedList<Tree>) tempQueue).addFirst(node.right);
                    }

                    if (node.left != null) {
                        ((LinkedList<Tree>) tempQueue).addFirst(node.left);
                    }

                }
                queue = tempQueue;
            }
            level++;
        }
    }

    public static void main(String args[]) {

/*        Tree root = new Tree(1);
        root.insertComplete(root, 2);
        root.insertComplete(root, 3);
        root.insertComplete(root, 4);
        root.insertComplete(root, 5);
        root.insertComplete(root, 6);

        root.insertComplete(root, 7);
        root.insertComplete(root, 8);
        root.insertComplete(root, 9);
        root.insertComplete(root, 10);
        root.insertComplete(root, 11);
        root.insertComplete(root, 12);
        root.insertComplete(root, 13);
        root.insertComplete(root, 14);
        root.insertComplete(root, 15);

        //root.right.right.right = null;
        Tree.printLevelOrder(root);

        Tree deepestNode = Tree.deepestNode(root);
        System.out.println("the deepest node is -" + deepestNode.toString());
        boolean isDeleted = Tree.deleteNode(root, deepestNode);
        System.out.println("isDel - " + isDeleted);
        Tree.printLevelOrder(root);*/

//        Tree root = new Tree(3);
//        root.left = new Tree(2);
//        root.right = new Tree(4);
//        root.left.left = new Tree(1);
//        root.left.right = new Tree(3);
//        root.right.right = new Tree(5);



        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.right.left = new Tree(4);
        root.left.right = new Tree(5);

        if (isFoldable(root))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isFoldable(Tree root) {
        if (root == null) {
            return true;
        }
        return isFoldCheck(root.left, root.right);
    }

    private static boolean isFoldCheck(Tree left, Tree right) {
        if (left == null && right == null) {
            return true;
        }
        boolean canFold = true;
        if (left.left != null) {
            if (right.right != null) {
                canFold = isFoldCheck(left.left, right.right);
            } else {
                return false;
            }
        }

        if (canFold && left.right != null) {
            if (right.left != null) {
                canFold = isFoldCheck(left.left, right.right);
            } else {
                return false;
            }
        }
        return canFold;
    }

    private static boolean treeContinuous(Tree root) {
        boolean isContinous = true;
        if (root == null) {
            return true;
        }
        if (root.right != null) {
            if (Math.abs(root.data - root.right.data) == 1) {
                isContinous = treeContinuous(root.right);
            } else {
                isContinous = false;
            }
        }
        if (isContinous == true) {
            if (root.left != null) {
                if (Math.abs(root.data - root.left.data) == 1) {
                    isContinous = treeContinuous(root.left);
                } else {
                    isContinous = false;
                }
            }
        }

        return isContinous;

    }

    private static boolean deleteNode(Tree root, Tree deepestNode) {
        if (root == null) {
            return false;
        }
        boolean isDeleted = false;
        if (root.right == deepestNode) {
            root.right = null;
            isDeleted = true;
        } else if (root.left == deepestNode) {
            root.left = null;
            isDeleted = true;
        }
        if (isDeleted != true) {
            isDeleted = deleteNode(root.right, deepestNode);
            if (!isDeleted)
                isDeleted = deleteNode(root.left, deepestNode);
        }

        return isDeleted;

    }

    private static Tree deepestNode(Tree root) {
        if (root == null) {
            return null;
        }
        Tree node = new Tree();
        if (root.right != null) {
            node = deepestNode(root.right);
        } else if (root.left != null) {
            node = deepestNode(root.left);
        } else {
            node = root;
        }
        return node;
    }

    @Override
    public String toString() {
        return "data = " + this.data + ", left = " + this.left + " , right = " + this.right;
    }
}
