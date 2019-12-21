package collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetUnderstanding {

	public static void main(String[] args) {
		Set<Integer> hashset = new HashSet<>();
		hashset.add(2);
		hashset.add(5);
		hashset.add(9);
		
		Iterator<Integer> it = hashset.iterator();
		while(it.hasNext()){
			//if we want to remove something from the set, we should use remove method
			//of iterator otherwise it may throw ConcurrentModificationException
			//on best effort basis. 
			if(it.next() == 2){
				it.remove();
			}
			
		}
		System.out.println("Printing HashSet using toString method "+ hashset);
		

	}

}
