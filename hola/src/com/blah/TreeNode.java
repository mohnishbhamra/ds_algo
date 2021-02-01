package com.blah;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(Integer a[]) {
        TreeNode nodeArr[] = new TreeNode[a.length];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i] == null) {
                nodeArr[i] = null;
            } else {
                nodeArr[i] = new TreeNode(a[i]);
            }
        }
        this.val = a[0];
        nodeArr[0] = this;

        for (int i = 0; i < len; i++) {
            if (nodeArr[i] != null) {
                int path = ((i + 1) * 2);
                if (path < len) {
                    nodeArr[i].right = nodeArr[path];
                }
                if (path - 1 < len) {
                    nodeArr[i].left = nodeArr[path - 1];
                }
            }
        }
    }

    public boolean verify(Integer[] orignalArray) {
        ArrayList<TreeNode> list = new ArrayList<>(100);
        TreeNode ptr = this;
        list.add(ptr);
        for (int i = 0; i < 99; i++) {
            list.add(null);
        }
        int index = 0;
        do {
            ptr = list.get(index);
            int right = (index + 1) * 2;
            int left = (index + 1) * 2 - 1;
            if (ptr != null) {
                if (ptr.left != null) {
                    list.add(left, ptr.left);
                } else {
                    list.add(left, null);
                }

                if (ptr.right != null) {
                    list.add(right, ptr.right);
                } else {
                    list.add(right, null);
                }
            }
            index++;
        } while (index <= 99);

        int size = 99;
        Integer[] itarr = new Integer[size];
        try {
            for (int i = 0; i < size; i++) {
                TreeNode node = list.get(i);

                if (node == null) {
                    itarr[i] = null;
                } else {
                    itarr[i] = node.val;
                }
            }
        } catch (Exception E) {
            int a = 0;
        }

        boolean isOrignal = true;
        System.out.println("orignal     " + " processed");
        for (int i = 0; i < orignalArray.length; i++) {
            Integer orignal = orignalArray[i];
            Integer processed = itarr[i];
            System.out.println("orignal " + orignal + " processed " + processed);
            if (orignal == null && processed == null) {
                continue;
            }
            if (orignal == null || processed == null) {
                isOrignal = false;
                break;
            }
            if (!(orignal.equals(processed))) {
                isOrignal = false;
                break;
            }
        }
        return isOrignal;

    }
}

