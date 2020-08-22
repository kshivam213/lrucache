package lrumultilevelcache;

public class Main {
	
public static void main(String args[]) {
		
		Memory memory = new Memory();
		memory.addCacheLevel(5);
		memory.addCacheLevel(10);
		memory.addCacheLevel(15);
		
		int totalWriteOpr = 8;
		int totalReadOpr = 8;
		long totalWriteTime = 0l;
		long totalReadTime = 0l;
		
		for(int i=1;i<=totalWriteOpr;i++) {
			
			long stTime = System.currentTimeMillis();
			memory.put("key"+i, "Record "+i);
			long enTime= System.currentTimeMillis();
			
			totalWriteTime+= (enTime-stTime);
		}
		
		System.out.println("Average Write Time for "+totalWriteOpr+" Write Operation is "+(totalWriteTime/totalWriteOpr));
		System.out.println("Available Spaces are ... ");
		memory.printAllFreeCapacity();
		
		for(int i=1;i<=totalReadOpr;i++) {
			
			long stTime = System.currentTimeMillis();
			Object data = memory.get("key"+i);
			if(data == null)
				System.out.println("No data found ");
			else
				System.out.println("Data is "+memory.get("key"+i));
			
			long enTime= System.currentTimeMillis();
			
			totalReadTime+= (enTime-stTime);
		}
		
		System.out.println("Average Read Time for "+totalReadOpr+" Read Operation is "+(totalReadTime/totalReadOpr));
		
	}
}
