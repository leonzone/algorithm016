package com.reiser.homework.other;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/11/5
 * Des: 替换算法
 * hash 表 + 双端队列
 */
class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    static class DLinkNode {
        int value;
        int key;
        DLinkNode pre;
        DLinkNode next;

        DLinkNode() {
        }

        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    int size;
    int capacity;
    DLinkNode head;
    DLinkNode tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        // 如果之前不存在
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            //放到 hash 表中
            cache.put(key, newNode);
            //放到头部
            addToHead(newNode);
            size++;
            //查过 capacity，移除最后一个
            if (size > capacity) {
                DLinkNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }


    private void addToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;

    }

}
