package com.rewindFast.Concurrent;

//public class TestJoin {
//}
class TestJoin extends Thread{
    String name;
    public TestJoin(String name){
        this.name=name;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){System.out.println(e);}
            System.out.println(i+name);
        }
    }
    public static void main(String args[]){
        TestJoin t1=new TestJoin("one");
        TestJoin t2=new TestJoin("two");
        TestJoin t3=new TestJoin("three");
        t1.start();
        t2.start();

        try{
            t1.join(1500);
        }catch(Exception e){System.out.println(e);}

        t3.start();

    }
}
