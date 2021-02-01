package com.rewindFast;

import java.util.Arrays;
import java.util.Comparator;

class myCustomComparator implements Comparator<Integer> {
    public int compare(Integer one, Integer two){
        return one-two;
    }
}
public class ComparatorStudy {

    public  static void main(String args[]){
        Integer arr[]={2,4,5,1,2,6,2,35};
        Arrays.sort(arr, new myCustomComparator());
        System.out.print("");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }

    }
}
