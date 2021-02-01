package com.rewindFast;
import java.util.*;

public class DequeStudy {
    public  static void main(String args[]){
        Deque<Integer> deque = new LinkedList();
        deque.addFirst(1);
        deque.addLast(10);
        deque.addLast(1);
        System.out.println("isEmpty ->"+deque.isEmpty());
        System.out.println("size ->"+deque.size());
        System.out.println("peek first ->"+deque.peekFirst());
        System.out.println("peek last ->"+deque.peekLast());
        deque.addLast(45);
        System.out.println("->>Deque ->"+deque);
        Integer removed = deque.removeLast();
        System.out.println("after removing last->>Deque ->"+deque);
        deque.removeFirst();
        System.out.println("after removing first->>Deque ->"+deque);

    }
}
