package com.rewindFast;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd_Semaphores {
}
class ZeroEvenOdd {
    private int n;
    int count = 0;
    Semaphore zero = new Semaphore(1,true);
    Semaphore even = new Semaphore(0,true);
    Semaphore odd = new Semaphore(0,true);
    Boolean inProgress = true;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(count<=n){
            zero.acquire();
            if(count == n){
                inProgress = false;
                odd.release();
                even.release();
                break;
            }
            printNumber.accept(0);
            count++;
            if(count%2==1){
                odd.release();
            } else{
                even.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        while(count<=n){
            even.acquire();
            if(inProgress && count<=n && count%2==0){
                printNumber.accept(count);
            }
            zero.release();
            if(!inProgress){
                break;
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(count<=n){
            odd.acquire();
            if(count<=n && count%2==1){
                printNumber.accept(count);
            }
            zero.release();
            if(!inProgress){
                break;
            }
        }
    }
}