package lrumultilevelcache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
	
	Map<String, Object> cache;
	int capacity;

	Cache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>();
	}

	public Object get(String key) {

		Object val = cache.get(key);

		if (val != null) {
			cache.remove(key);
			cache.put(key, val);
		}

		return val;
	}

	public void put(String key, Object value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		} else {
			if (capacity == cache.size()) {
				String firstItemKey = cache.entrySet().iterator().next().getKey();
				cache.remove(firstItemKey);
			}
		}
		cache.put(key, value);
	}
	
	public int freeCapacity() {
		return (capacity - cache.size());
	}
}
