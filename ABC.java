import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ABC {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("ayan",1),new Student("ayan",1),new Student("abhishek",2));
		list.stream().distinct().forEach(System.out::println);
		ArrayList<Integer> intList = new ArrayList<>();
		random(intList);
	}
	
	public static void random(ArrayList<?> l){
		
	}
	
	public void random1(Number n){
		
	}
}


class Student{
	String name;
	int id;
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object stu) {
		return true;
	}

}

