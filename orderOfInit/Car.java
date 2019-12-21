package orderOfInit;

public class Car extends Vehicle{
	String fuel;
	
	{System.out.println("instance initializer child");}
	 
	public Car(){
		super(7);
		System.out.println("default constructor child");
		
	}
	
	public Car(String fuel){
		this();
	}
	
	static{System.out.println("static initializer child");}
	
}
