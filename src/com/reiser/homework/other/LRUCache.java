package com.reiser.homework.other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/11/5
 * Des: 替换算法
 * LinkedHashMap 本身就实现了 LRUCache
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
