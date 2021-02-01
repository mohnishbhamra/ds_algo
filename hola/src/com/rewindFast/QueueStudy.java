package com.rewindFast;
import  java.util.*;
public class QueueStudy {
    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList(); //here Queue is an interface
        queue.add(1);
        queue.add(3);
        queue.remove();
        System.out.println(queue.peek());
    }
}
