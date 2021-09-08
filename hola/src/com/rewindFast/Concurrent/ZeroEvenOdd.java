package com.rewindFast.Concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

class ZeroEvenOdd {
    private int n;
    private Queue<Integer> queue;
    private Object o = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
        queue = new LinkedList<>();
        for (int i = 1; i <= 2 * n; ++i) {
            if (i % 2 == 1) {
                queue.add(0);
            } else {
                queue.add(i / 2);
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (!queue.isEmpty()) {
            synchronized (o) {
                while (!queue.isEmpty() && queue.peek() == 0) {
                    printNumber.accept(queue.poll());
                }
            }
            TimeUnit.MICROSECONDS.sleep(5);//Questioner's bug
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (!queue.isEmpty()) {
            synchronized (o) {
                while (!queue.isEmpty() && queue.peek() != 0 && queue.peek() % 2 == 0) {
                    printNumber.accept(queue.poll());

                }
            }
            TimeUnit.MICROSECONDS.sleep(5);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (!queue.isEmpty()) {
            synchronized (o) {
                while (!queue.isEmpty() && queue.peek() % 2 == 1) {
                    printNumber.accept(queue.poll());
                }
            }
            TimeUnit.MICROSECONDS.sleep(5);
        }
    }

    private class IntConsumer {
        public void accept(Integer poll) {
        }
    }
}