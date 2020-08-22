1 Problem 

Class SingleLevelCache has solution for following requirement

	Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
	
	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
	
	The cache is initialized with a positive capacity.
	
	Follow up:
	Could you do both operations in O(1) time complexity?

Solution uses LinkedHashMap for both purpose maintaining cache and storing key value pair so that eviction takes O(1) complexity 

2 Problem MutilevelCache

It has Cache class which holds capacity and LinkedHashMap to store key value pair. It also has Memory which contains Map of caches. Finally It has driver class which Has N read and write. 