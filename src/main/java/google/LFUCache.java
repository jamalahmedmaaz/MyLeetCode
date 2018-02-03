package google;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * esign and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 capacity
 * );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LFUCache {
    HashMap<Integer, Integer> keyValueMap = new HashMap<>();
    HashMap<Integer, Integer> keyVsFrequencyMap = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> frequencyVsKeysMap = new HashMap<>();
    int capacity;
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyVsFrequencyMap = new HashMap<>();
        frequencyVsKeysMap = new HashMap<>();
        frequencyVsKeysMap.put(1, new LinkedHashSet());
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(10);

        for (int i = 1; i <= 10; i++) {
            lfuCache.put(i, i);
        }
        System.out.println();
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        System.out.println("---- 2" + keyValueMap);
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            get(key);
        } else {
            if (keyValueMap.size() >= capacity) {
                //Remove the least frequent element.
                int elementKey = frequencyVsKeysMap.get(min).iterator().next();
                frequencyVsKeysMap.get(min).remove(elementKey);
                keyValueMap.remove(elementKey);
            }
            keyValueMap.put(key, value);
            keyVsFrequencyMap.put(key, 1);
            System.out.println("---- asdfsadf");
            min = 1;
            frequencyVsKeysMap.get(1).add(key);
        }
    }

    public int get(int key) {
        System.out.println("---- get");
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }

        int count = keyVsFrequencyMap.get(key);

        keyVsFrequencyMap.put(key, count + 1);

        frequencyVsKeysMap.get(count).remove(key);

        if (count == min && frequencyVsKeysMap.get(count).size() == 0) {
            min++;
        }

        if (!frequencyVsKeysMap.containsKey(count + 1))
            frequencyVsKeysMap.put(count + 1, new LinkedHashSet());

        frequencyVsKeysMap.get(count + 1).add(key);

        return keyValueMap.get(key);
    }
}