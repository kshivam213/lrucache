package lrumultilevelcache;

public class Driver {
	
	MemoryInterface memory;
	int totalReadOpr;
	int totalWriteOpr;
	
	Driver(MemoryInterface memory, int totalReadOpr, int totalWriteOpr){
		
		this.memory= memory;
		this.totalReadOpr= totalReadOpr;
		this.totalWriteOpr= totalWriteOpr;
	}

	public static void main(String args[]) {
		
		Driver driver= new Driver(new Memory(), 8, 8);
		
		long totalWriteTime = 0l;
		long totalReadTime = 0l;
		
		driver.memory.addCacheLevel(5);
		driver.memory.addCacheLevel(10);
		driver.memory.addCacheLevel(15);
		
		for (int i = 1; i <= driver.totalWriteOpr; i++) {

			long stTime = System.currentTimeMillis();
			driver.memory.put("key" + i, "Record " + i);
			long enTime = System.currentTimeMillis();
			
			totalWriteTime += (enTime - stTime);
		}

		System.out.println("Average Write Time for " + driver.totalWriteOpr + " Write Operation is " + (totalWriteTime / driver.totalWriteOpr));
		System.out.println("Available Spaces are ... ");
		driver.memory.totalFreeSpaces();

		for (int i = 1; i <= driver.totalReadOpr; i++) {

			long stTime = System.currentTimeMillis();
			Object data = driver.memory.get("key" + i);
			if (data == null)
				System.out.println("No data found ");
			else
				System.out.println("Data is " + driver.memory.get("key" + i));

			long enTime = System.currentTimeMillis();

			totalReadTime += (enTime - stTime);
		}

		System.out.println("Average Read Time for " + driver.totalReadOpr + " Read Operation is " + (totalReadTime / driver.totalReadOpr));

	}
}
