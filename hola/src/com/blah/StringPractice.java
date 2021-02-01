package com.blah;

public class StringPractice {
    public static void main(String args[]){
        String input= "AABAACAADAABAABA";
        String pat = "AABA";
        System.out.println(input.regionMatches(10,pat,0,4));

    }
}
