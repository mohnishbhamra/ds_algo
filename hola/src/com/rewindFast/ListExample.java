package com.rewindFast;

import java.util.ArrayList;
import java.util.Iterator;

public class ListExample {

    public static void main(String arsp[]){

        CustomArrayList ar1 = new CustomArrayList();
        CustomArrayList ar2 = new CustomArrayList();
        CustomArrayList ar3 = new CustomArrayList();

        ar1.add(ar2);
        ar2.add(ar3);
        ar3.add(ar1);

        System.out.println("calling-"+ar1.toString());


    }
}

class CustomArrayList extends ArrayList<Object> implements  Comparable<CustomArrayList>{
    CustomArrayList refernce;
    public CustomArrayList(){
        refernce = this;
    }
    @Override
    public String toString() {
        CustomArrayList curr = this.refernce;
        Iterator it = this.iterator();

        String a = "";
        while(it.hasNext()){
            Object obj = it.next();
            if(obj == this.refernce){
                return "circular linked list example";
            }

        }
        return super.toString();
//        return super.toString();
    }

    @Override
    public int compareTo(CustomArrayList o) {
        int val=1;
        if(this.refernce == o){
            val=0;
        }
        return val;
    }
}