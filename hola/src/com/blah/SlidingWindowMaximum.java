package com.blah;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k];
        Deque<Integer> deque = new LinkedList<>();
        int maxIndex = 0;
        for(int i=1;i<=k;i++){
            int val = nums[i];
            int prev = nums[maxIndex];
            if(val>prev){
                maxIndex = i;
            }
        }

        // we got maximum values at maxIndex
        //push it in rear of dequeue
        int i=0;
        ans[i]=maxIndex;
        deque.addLast(maxIndex);

        for(int j=k+1;j<nums.length;j++){
            int rear = deque.peekLast();
            int incomingValue = nums[j];
            while (!deque.isEmpty() && incomingValue>rear){
                deque.removeLast();
                rear = deque.peekLast();
            }
            deque.addLast(incomingValue);
            ans[++i]=deque.peekFirst();
        }

        return ans;
    }
}
