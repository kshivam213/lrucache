package lrumultilevelcache;

public interface MemoryInterface {
	
	public void addCacheLevel( int capacity);
	public void removeCacheLevel();
	public Object get(String key);
	public void put(String key, Object value);
	public void totalFreeSpaces();
}
