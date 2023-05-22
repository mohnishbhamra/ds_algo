package com.leet;

public class Driver {
    public static void main(String args[]) {
        int[] x = new LeetCodePlusOne().plusOne(new int[]{1,5});
        System.out.println("ans is ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
        }
        System.out.println("\nans end ");

    }
}
