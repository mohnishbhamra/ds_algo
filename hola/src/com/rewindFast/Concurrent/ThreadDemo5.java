package com.rewindFast.Concurrent;



class ThreadDemo5 extends Thread
{
    final StringBuffer sb1 = new StringBuffer();
    final StringBuffer sb2 = new StringBuffer();

    public static void main(String args[])
    {
        final ThreadDemo5 h = new ThreadDemo5();
//        synchronized (args){
//            try {
//                System.out.println("waiting..");
//                args.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    h.sb1.append("Java");
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    h.sb2.append("Thread");
                    System.out.println(Thread.currentThread().getName()+h.sb1);
                    System.out.println(Thread.currentThread().getName()+h.sb2);
                }
            }
        }.start();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    h.sb1.append("Mutithreading");
                            h.sb2.append("Example");
                    System.out.println(Thread.currentThread().getName()+h.sb2);
                    System.out.println(Thread.currentThread().getName()+h.sb1);
                }
            }
        }.start();
    }
}