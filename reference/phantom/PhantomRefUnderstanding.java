package reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class PhantomRefUnderstanding {
	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue<HeavyObject> refQueueForPhantom = new ReferenceQueue<>();
		HeavyObject heavy = new HeavyObject();
		PhantomReference<HeavyObject> phantomRefToHeavyObject = new PhantomReference<HeavyObject>(heavy, refQueueForPhantom);
		System.gc();
		Thread.sleep(5000);
		System.out.println(refQueueForPhantom.poll());
		System.out.println(phantomRefToHeavyObject.get());
		heavy = null;
		System.gc();
		Thread.sleep(5000);
		Reference<? extends HeavyObject> phantomRefAfterGarbageCollected = refQueueForPhantom.poll();
		System.out.println(phantomRefAfterGarbageCollected);
		phantomRefAfterGarbageCollected.get().cleanUp();
	}
}


class HeavyObject{
	
	public void cleanUp(){
		System.out.println("Cleaning up after garbage collected");
	}
}