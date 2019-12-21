package passbyvalue;

public class PassByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.name = "Ayan";
		emp.age = 27;
		test(emp);
		System.out.println(emp);
	}
	
	public static void test(Employee e){
		/*e = new Employee();*/
		e.name = "Changed";
		e.age = 50;
	}
}


class Employee{
	String name;
	int age;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	
	
}