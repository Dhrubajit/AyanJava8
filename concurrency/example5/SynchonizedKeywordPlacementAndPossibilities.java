package concurrency.example5;

public class SynchonizedKeywordPlacementAndPossibilities {
	private static Object monitorObjectMadeForStaticLock = new Object();
	private Object monitorObjectMadeForInstanceMethod = new Object();
	
	public static void testSyncBlockOnStaticMethod(){
		synchronized(monitorObjectMadeForStaticLock){
			//do something
		}
	}
	
	public void testSyncBlockOnInstanceMethod(){
		synchronized(monitorObjectMadeForInstanceMethod){
			//do something
		}
	}
	
	public synchronized void testSyncInstanceMethod(){
		//do something
	}
	
	public void testSyncInstanceMethodUsingSyncBlock(){
		synchronized(this){
			//do Something
		}
	}
	
	public synchronized void testSyncStaticMethod(){
		//do something
	}
	
	public void testSyncStaticMethodUsingSyncBlock(){
		synchronized(SynchonizedKeywordPlacementAndPossibilities.class){
			//do Something
		}
	}
	
	
}
