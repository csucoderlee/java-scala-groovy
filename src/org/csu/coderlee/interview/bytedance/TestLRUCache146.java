package org.csu.coderlee.interview.bytedance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestLRUCache146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1) == 1);
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2) == -1);
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1) == -1);
        System.out.println(cache.get(3) == 3);
        System.out.println(cache.get(4) == 4);

    }

}

class LRUCache {

    HashMap<Integer, Integer> map;
    Queue<Integer> queue;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            map.put(key, value);
        } else {
            if (queue.size() == capacity) {
                map.remove(queue.poll());
                queue.add(key);
            } else {
                queue.add(key);
            }
            map.put(key, value);
        }
    }
}
