package com.rewindFast;
import  java.util.*;
public class PriorityQueueStudy {

    public static void main(String argsp[]){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();//min heap- min element at top
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());//max heap- max element at top
        priorityQueue.add(2);
        priorityQueue.add(56);
        priorityQueue.add(1);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }
}
