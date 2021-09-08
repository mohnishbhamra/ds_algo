package com.rewindFast.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo2 implements Runnable
{
    private AtomicInteger x= new AtomicInteger();
    private int y=0;
    public static void main(String [] args)
    {
        ThreadDemo2 obj = new ThreadDemo2();
        Thread t=new Thread(obj,"one");
        t.start(); /*Line 8*/
        try {
            t.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        (new Thread(obj,"two")).start(); /*Line 8*/
    }
    public   void run () /*Line 11*/
    {
        for (int i=0;i<10;i++) /*Line 13*/
        {

            x.incrementAndGet();
            y++;
            System.out.println(x+" , "+y+Thread.currentThread().getName());
        }
    }
}