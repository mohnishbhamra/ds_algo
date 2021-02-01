package com.lld;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class JsonObject<K, V> extends HashMap<K, V>{

}

//reading through, k ko string, rest if string , otherwise in recursion

class JSONParser{
    JsonObject parse(String input){
        String key="gotSome";
        String val = "someValue";
        JsonObject<String,String> map= new JsonObject<>();
        //map.put(key,val);
        //return map;

        //if its another json , then
        JsonObject valx = parse(input.substring(5,input.length()));
        JsonObject<String,JsonObject> mapx = new JsonObject<>();
        mapx.put(key,valx);
        return mapx;
    }
}