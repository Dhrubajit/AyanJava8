package orderOfInit;

public class Vehicle {
	
	public Vehicle(int noOfTyres){
		noOfTyre = noOfTyres;
	}
	
	static{type = "Sports";System.out.println("static block super 1");}
	static String type;
	static{System.out.println("static block super 2");}
	
	{System.out.println("instance initializers super 1");}
	{noOfTyre = 4;System.out.println("instance initializers super 2");}
	static {
		int[] arr = new int[]{1,2,3};
		System.out.println(arr[100]);
	}
	int noOfTyre;
}
