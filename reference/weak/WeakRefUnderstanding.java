package reference.weak;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakRefUnderstanding {
	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue<HeavyObject> refQueueForWeak = new ReferenceQueue<>();
		HeavyObject heavy = new HeavyObject();
		WeakReference<HeavyObject> weakRefToHeavyObject = new WeakReference<HeavyObject>(heavy, refQueueForWeak);
		System.gc();
		Thread.sleep(5000);
		System.out.println(refQueueForWeak.poll());
		System.out.println(weakRefToHeavyObject.get());
		System.out.println(weakRefToHeavyObject.isEnqueued());
		heavy = null;
		System.gc();
		Thread.sleep(5000);
		System.out.println(weakRefToHeavyObject.isEnqueued());
		Reference<? extends HeavyObject> weakRefAfterGarbageCollected = refQueueForWeak.poll();
		System.out.println(weakRefAfterGarbageCollected);
		System.out.println(weakRefToHeavyObject.isEnqueued());
		System.out.println();
		weakRefAfterGarbageCollected.get().cleanUp();
	}
}


class HeavyObject{
	
	public void cleanUp(){
		System.out.println("Cleaning up after garbage collected");
	}
}