package com.rewindFast;
import java.util.*;
public class StackStudy {
    public  static void main(String args[]){
        Stack<Integer> stack = new Stack();
        //stack.pop(); stack pop when no elements brings execption
        stack.push(2);
        stack.pop();
        stack.push(4);
        stack.push(7);
        System.out.println(stack.isEmpty());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

    }

}
