package staticmagic;

public class Animal {
	int i =9;
	final int count;
	
	public Animal(){
		this(3);
	}
	public Animal(int c){
		count=10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an = new Animal();
		
		System.out.println(an.count);
	}
	
	public static int asd(){
		return 10;
	}
	

}
