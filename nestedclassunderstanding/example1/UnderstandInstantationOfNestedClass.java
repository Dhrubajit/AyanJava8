package nestedclassunderstanding.example1;

class OuterClass {
	//remove static to understand that static nested class can not access instance member
	//of enclosing class
	private static int outerX;
	
	public void outerTest(){
		System.out.println("outer");
	}
	
	NestedClass nested = new NestedClass();
	InnerClass inner = new InnerClass();
	public static class NestedClass{
		interface abc{
			
		}
		private int innerY;
		public static void nestedTest(){
			
			System.out.println(outerX);
		}
	}
	
	public class InnerClass{
		private static final int innerY=9;
		{}
		public void innerTest(){
			System.out.println(outerX);
			outerTest();
		}
		
	}
	
}

public class UnderstandInstantationOfNestedClass{
	public static void main(String[] args) {
		//Creating object of static nested class from outside of Outer-Inner structure
		OuterClass.NestedClass nestedclass = new OuterClass.NestedClass();
		
		//Creating object of inner class from outside of Outer-Inner structure
		OuterClass.InnerClass innerclass = new OuterClass().new InnerClass();
	}
}