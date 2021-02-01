package com.rewindFast;

import java.util.Collections;
import java.util.Vector;

public class VectorStudy {
    public  static void main(String args[]){
        Vector<Integer> vector = new Vector();
        vector.add(31);
        vector.add(299);
        vector.add(35);
        vector.add(42);
        vector.add(5);
        vector.add(2,50);
        vector.remove(2);
        System.out.println("element at index 0 can be get from vector -->"+vector.get(0));
        System.out.println("size of vector -->"+vector.size());
        System.out.println("is vector empty ?-->"+vector.isEmpty());
        System.out.println("normal"+vector.toString());
        Collections.sort(vector);
        System.out.println("sortec asc"+vector.toString());
        Collections.sort(vector,Collections.reverseOrder());
        System.out.println("sorted desc"+vector.toString());
        //List(Interface)/ArrayList(class) is similar to Vector , only difference is Vector is thread safe but List is not
    }
}
