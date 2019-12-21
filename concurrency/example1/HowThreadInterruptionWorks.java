package concurrency.example1;

public class HowThreadInterruptionWorks {
	public static void main(String[] args) {
		//interruption requested.Interrupted Exception thrown. But it still goes on.
		Thread t1 = new Thread(() -> {for(int i=0;i<5;i++){
			System.out.println("T1 Thread started execution");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Interruption occured.This task is taking too long to complete. That is why interrupted by other thread");
			}
			}			
		});
		
		t1.start();
		t1.interrupt();
		//interruption requested. Due to careful handling of code, thread finishes early.
		Thread t2 = new Thread(() -> {for(int i=0;i<5;i++){
			System.out.println("T2 Thread started execution");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
			}			
		});
		t2.start();
		t2.interrupt();
		System.out.println("Main Thread completes");
	}
	
	//In Java, one thread cannot stop the other thread. 
	//A thread can only request the other thread to stop.
	//The request is made in the form of an interruption.
	
}


