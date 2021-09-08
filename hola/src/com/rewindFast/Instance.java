package com.rewindFast;
public class Instance {
    public static void main(String args[]){
        System.out.println("main Instance");
        Bike b1=new Bike();
//        Instance b2=new Instance();
    }
}

class Bike {
    static Bike x;
    static {
        System.out.println("static block");
        x = new Bike();

    }
    int speed;

    Bike(){System.out.println("constructor is invoked");}

    {System.out.println("instance initializer block invoked");}


}