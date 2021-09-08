package com.rewindFast;

import java.util.HashMap;
import java.util.Map;

public class MapEntry implements Map.Entry<Integer,Integer>{
    Integer key,val;
    MapEntry(Integer key, Integer val){
        this.key = key;
        this.val = val;
    }
    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return val;
    }

    @Override
    public Integer setValue(Integer value) {
        val = value;
        return val;
    }
}
