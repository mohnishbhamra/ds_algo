package com.rewindFast.Concurrent;



class ThreadDemo4 implements Runnable
{
    int y=0;
    String x;
    public void run()
    {
        for(int i = 0; i < 10; i++)
            synchronized(this)
            {
                y++;
                x = "Hello";
                System.out.println(i+ x + " "+y+"  " + Thread.currentThread().getName() + " ");
            }
    }
    public static void main(String args[])
    {
        ThreadDemo4 run = new ThreadDemo4 ();
        Thread obj1 = new Thread(run);
        Thread obj2 = new Thread(run);
        obj1.start();
        obj2.start();
    }
}