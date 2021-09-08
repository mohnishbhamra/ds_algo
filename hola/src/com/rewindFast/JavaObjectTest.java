package com.rewindFast;

import java.util.HashMap;
import java.util.Map;

public class JavaObjectTest extends Object{
    int x;
    public JavaObjectTest(int x){
        this.x=x;
    }
    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String args[]){
        JavaObjectTest j1= new JavaObjectTest(4);
        JavaObjectTest j2= new JavaObjectTest(5);
        Map<JavaObjectTest,Integer> map= new HashMap<>();
        System.out.println(j1.hashCode());
        System.out.println(j2.hashCode());
        System.out.println(j1==j2);
        map.put(j1,4);
        map.put(j2,5);


    }
}
