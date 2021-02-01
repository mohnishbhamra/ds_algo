package com.rewindFast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapStudy {
    public  static void main(String args[]){
        HashMap<Integer,String> map = new HashMap();
        map.put(1,"hello");
        map.put(2,"hello2");
        map.put(3,"hello3");
        String val = map.get(1);
        System.out.println(val);
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
        map.put(45,"lets iterate");
        map.put(23,"yeah");
        System.out.println("for each style");
        for(Map.Entry entry : map.entrySet()){
            Integer key = (Integer) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key->"+key+" : value->"+value);
        }

        System.out.println("Iterator style");
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry)it.next();
            Integer key = (Integer) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key->"+key+" : value->"+value);
        }
    }
}
