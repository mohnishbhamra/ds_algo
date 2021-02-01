package com.blah;

import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Object xsol[] = search(root, x, 0, null);
        Object ysol[] = search(root, y, 0, null);

        Integer xDepth = (Integer) xsol[0];
        TreeNode xParent = (TreeNode) xsol[1];

        Integer yDepth = (Integer) ysol[0];
        TreeNode yParent = (TreeNode) ysol[1];

        System.out.println("xDepth-" + xDepth + ", yDepth-" + yDepth);
        System.out.println("xParent-" + xParent.val + ", yParent-" + yParent.val);
        if (xDepth.equals(yDepth) && xParent.val != yParent.val) {
            return true;
        }

        return false;

    }

    public Object[] search(TreeNode root, int element, int depth, TreeNode parentNode) {
        Object ans[] = new Object[2];
        ans[0] = -1;
        ans[1] = null;

        if (root.val == element) {
            ans[0] = depth;
            ans[1] = parentNode;
            return ans;
        }

        if (root.left != null) {
            ans = search(root.left, element, ++depth, root);
            if ((int) ans[0] != -1) {
                return ans;
            } else {
                depth--;
            }
        }

        if (root.right != null) {
            ans = search(root.right, element, ++depth, root);
            if ((int) ans[0] != -1) {
                return ans;
            } else {
                depth--;
            }
        }

        return ans;
    }

   /* public ArrayList<Integer> solve2(TreeNode root) {


        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        ans.add(node.val);
        while (node.left != null) {
            stack.push(node.left);
            ans.add(node.left.val);
            node = node.left;
        }

        while (stack.isEmpty() != true) {
            node = stack.pop();
            if (node.right != null) {
                printAllLeaves(node.right, ans);
            }
        }

        QueueStudy<TreeNode> queue = new LinkedList<>();
        while (root.right != null) {
            ((LinkedList<TreeNode>) queue).add(root.right);
            root = root.right;
        }
        while (queue.isEmpty() != true) {
            node = ((LinkedList<TreeNode>) queue).remove();
            stack.push(node);
            if (node.left != null) {
                printAllLeaves(node.left, ans);
            }
        }

        while (stack.isEmpty() != true) {
            ans.add(stack.pop().val);
        }

        return ans;
    }*/

    public ArrayList<Integer> solve(TreeNode root) {


        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode node = root;
        printRootToLeftMost(root, ans);
        printAllLeaves(root,ans,leftMost);
        printRootToRightMost(root, ans);
        Iterator<Integer> it =ans.listIterator();
        int size=0;
        while (it.hasNext()){
            Integer val = it.next();
            if(val!=null){
                size++;
            } else {
                break;
            }
        }
        try{
        ans.remove(size-1);
        } catch (Exception e){

        }

        return ans;
    }

    static TreeNode righMostNode = null;

    public boolean printRootToRightMost(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            if (righMostNode == null) {
                return true;
            } else {
                return false;
            }
        }
        boolean right = printRootToRightMost(root.right, ans);
        boolean left = printRootToRightMost(root.right, ans);
        if (right && left && righMostNode == null) {
            righMostNode = root;
            return true;
        } else if(left||right){
            ans.add(root.val);
            return true;
        }
        return false;
    }

    static TreeNode leftMost = null;

    public boolean printRootToLeftMost(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return true;
        }
        if (leftMost == null) {
            ans.add(root.val);
        }

        boolean left = printRootToLeftMost(root.left, ans);
        boolean right = printRootToLeftMost(root.right, ans);
        if (left && right && leftMost == null) {
            leftMost = root;
            return false;
        }
        return false;
    }

    public boolean printAllLeaves(TreeNode root, ArrayList<Integer> ans, TreeNode leftMost) {
        if (root == null) {
            return true;
        }
        boolean left = printAllLeaves(root.left, ans, leftMost);
        boolean right = printAllLeaves(root.right, ans, leftMost);
        if (left && right && root != leftMost) {
            ans.add(root.val);
            return false;
        }
        return false;
    }


}