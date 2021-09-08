package com.rewindFast;

public class NullCheckComparison {
    public static void main(String args[]) {
        System.out.println("hi in null check comparison");
        Node x = null;
        Node y = null;
        if(x==y){
            System.out.println("null values can be checked for equality");
        }else{
            System.err.println("null values can not be checked for equality");
        }
    }
}
