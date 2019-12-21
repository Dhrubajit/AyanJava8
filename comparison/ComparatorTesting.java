package comparison;

import java.util.*;
import java.util.stream.Stream;

public class ComparatorTesting {
	public static void main(String[] args) {
		Comparator<Person> personComparator = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
		Person p1 = new Person();
		p1.setAge(3);
		p1.setName("Ayan");
		Person p2 = new Person();
		p2.setAge(4);
		p2.setName("Ayan");
		Person p3 = new Person();
		p3.setAge(5);
		p3.setName("Abhishek");
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list);
		System.out.println(list);
		
	}
}


class Person implements Comparable<Person>{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person o) {
		return this.age - o.age;
	}
}