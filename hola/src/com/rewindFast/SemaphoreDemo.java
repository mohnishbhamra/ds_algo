/*
LC:1114
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}

The same instance of Foo will be passed to three different threads.
Thread A will call first(),
 thread B will call second(),
  and thread C will call third().
   Design a mechanism and modify the program to ensure that second() is executed after first(),
and third() is executed after second().*/
package com.rewindFast;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
}
class Foo {

    Semaphore[] semaphores;
    public Foo() {
        try{
            semaphores = new Semaphore[3];
            for(int i=0;i<3;i++){
                semaphores[i] = new Semaphore(1,true);
                semaphores[i].acquire();
            }
            semaphores[0].release();
        }catch(Exception e){}
    }

    public void first(Runnable printFirst) throws InterruptedException {
        //semaphores[0].acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphores[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphores[1].acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphores[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphores[2].acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphores[0].release();
    }
}