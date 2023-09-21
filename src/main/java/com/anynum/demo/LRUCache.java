package com.anynum.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LRUCache {

    Map<Integer,Integer[]> cache;
    int capacity;

    Set<Integer> set;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.set = new HashSet<>(capacity);
    }
    
    public int get(int key) {
        if (set.contains(key)){
            return cache.get(key)[0];
        }
        return -1;

    }
    
    public void put(int key, int var) {
        if (cache.containsKey(key)){
            Integer[] values = cache.get(key);
            values[0] = var;
            values[1] = 0;
        }
    }
}