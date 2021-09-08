package com.rewindFast.Concurrent;


class MyThreadX extends Thread
{
    MyThreadX() {}
    MyThreadX(Runnable r) {super(r); }
    public void run()
    {
        System.out.print("Inside Thread ");
    }
}
class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.print(" Inside Runnable");
    }
}
class ThreadDemo3
{
    public static void main(String[] args)
    {
//        new MyThreadX().run();
        RunnableDemo d = new RunnableDemo();
        MyThreadX m = new MyThreadX(d);
        m.start();
//        new Thread(new RunnableDemo()).start();
    }
}