package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListFunctionalities {

	public static void main(String[] args) {

		//LinkedList acting as Queue
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(5);
		queue.add(2);
		//LinkedList Implementation of Queue allows null
		queue.add(null);
		queue.offer(4);
		queue.forEach(System.out::println);
		System.out.println("I want to peek at element but do not want to remove it "+ queue.peek());
		queue.remove();
		queue.forEach(System.out::println);
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.forEach(System.out::println);
		//queue.element(); //It will throw NoSuchElementException when the queue is empty
		//queue.remove(); // It will throw NoSuchElementException when the queue is empty
		System.out.println("queue.poll() works like remove() but instead of throwing exception it returns a special value " + queue.poll());

	}

}
