package com.rewindFast;

import java.util.*;

public class ConcurrentModificationExample {
    public static void main(String args[]){
        List<String> arr = new ArrayList();
        arr.add("asd0");
        arr.add("asd1");
        arr.add("asd2");
        arr.add("asd3");
        boolean removed =false;
        for(int i=0;i<arr.size();i++){
            if(i==1 && !removed){
                arr.remove(i);
                arr.add(i,"removed");
                i--;
                removed=true;
                continue;
            }
            System.out.println(arr.get(i));


        }
    }
}
