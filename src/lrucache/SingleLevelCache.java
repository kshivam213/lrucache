package lrucache;

import java.util.LinkedHashMap;

/**
 * LeetCode Problem 
 * Url - https://leetcode.com/problems/lru-cache/
 * @author shivamkumar
 *
 */
public class SingleLevelCache {

	public int capacity;

	private LinkedHashMap<Integer, Integer> cache;

	public SingleLevelCache(int capacity) {
		cache = new LinkedHashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		
		Integer val = cache.get(key);
		
		if(val != null) {
			cache.remove(key);
			cache.put(key, val);
		}
	
		return val;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		} else {
			if (capacity == cache.size()) {
				int firstItemKey = cache.entrySet().iterator().next().getKey();
				cache.remove(firstItemKey);
			}
		}
		cache.put(key, value);
	}
}