package lrumultilevelcache;

import java.util.HashMap;
import java.util.Map;

public class Memory implements MemoryInterface{
	
	
	Map<String, Cache> memorySystem = new HashMap<>();
	int maxCacheLevel=0;
	
	@Override
	public void addCacheLevel( int capacity) {
		String cacheLevel = "l"+(++maxCacheLevel);
		memorySystem.put(cacheLevel,  new Cache(capacity));
	}
	
	@Override
	public void removeCacheLevel() {
		String levelToDel= "l"+(maxCacheLevel--);
		memorySystem.remove(levelToDel);
	}
	
	@Override
	public Object get(String key) {
		
		Cache cache = memorySystem.get("l1");
		Object data = cache.get(key);
		
		if(data != null) {
			for(int index= 2;index<=maxCacheLevel;index++) {
				String keyToGet = "l"+index;
				Cache deepCache = memorySystem.get(keyToGet);
				deepCache.put(key, data);
			}
		}
		
		return data;
	}
	
	@Override
	public void put(String key, Object value) {
		
		Cache cache = memorySystem.get("l1");
		Object data = cache.get(key);
		
		if(data == null) {
			cache.put(key, value);
			for(int index= 2;index<=maxCacheLevel;index++) {
				
				String keyToGet = "l"+index;
				Cache deepCache = memorySystem.get(keyToGet);
				
				if(deepCache.get(keyToGet) != null)
					break;
				deepCache.put(key, value);
			}
		}
	}
	
	@Override
	public void totalFreeSpaces() {
		for(int index= 1;index<=maxCacheLevel;index++) {
			System.out.println("Free capacity for l"+index+" : "+memorySystem.get("l"+index).freeCapacity()); 
		}
	}
}
