package overloading;

public class OverLoading {

	{System.out.println("abc");}
	int abc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(7.86f);

	}
	
	public static void test(double s){
		System.out.println("double");
	}
	
	public static void test(float s){
		System.out.println("float");
	}
	

}

class Employee{
	String name;
	int age;
}

class Clerk extends Employee{
	String role;
}