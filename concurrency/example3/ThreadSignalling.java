package concurrency.example3;

public class ThreadSignalling {

	public static void main(String[] args) throws InterruptedException {
		MySignal sharedObj = new MySignal();
		Task1 run1 = new Task1();
		run1.setSharedObj(sharedObj);
		Task2 run2 = new Task2();
		run2.setSharedObj(sharedObj);
		Thread t1 = new Thread(run1, "task1");
		Thread t2 = new Thread(run2,"task2");
		t1.start();
		//t1.join();
		// To make sure wait is called before notify.
		//In short to avoid missed signal scenario
		Thread.sleep(1000);
		t2.start();

	}

}

class MyMonitorObject{
	
}

class MySignal{
	MyMonitorObject mutex = new MyMonitorObject();
	
	public void doWait(){
		synchronized (mutex) {
			System.out.println("Before caling wait()"+Thread.currentThread().getName());
			try {
				mutex.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After caling wait()"+Thread.currentThread().getName());
		}
	}
	
	public void doNotify(){
		synchronized (mutex) {
			System.out.println("Before caling notify() by "+Thread.currentThread().getName());
			mutex.notify();
			System.out.println("After caling notify() by "+Thread.currentThread().getName());
		}
	}
}

class Task1 implements Runnable{
	
	private MySignal sharedObj;

	public MySignal getSharedObj() {
		return sharedObj;
	}

	public void setSharedObj(MySignal sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		System.out.println("Inside run method of task1");
		sharedObj.doWait();
		
	}
	
}


class Task2 implements Runnable{
	
	private MySignal sharedObj;

	public MySignal getSharedObj() {
		return sharedObj;
	}

	public void setSharedObj(MySignal sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		System.out.println("Inside run method of task2");
		sharedObj.doNotify();
		
	}
	
}