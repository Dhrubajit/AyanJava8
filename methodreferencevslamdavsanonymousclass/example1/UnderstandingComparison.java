package methodreferencevslamdavsanonymousclass.example1;

public class UnderstandingComparison {

	 public boolean numCheck(IntPredicate p, int n) {
	        return p.check(n);
	    }
	    public static void main(String[] args) {
	    	UnderstandingComparison demo = new UnderstandingComparison();
	        boolean result;
	        int num = 9;
	        // Here, Using lambda expression to check if a number is even
	        IntPredicate lb1 = number -> (number % 2) ==0;
	        result = demo.numCheck(lb1, num);
	        System.out.println("Using lambda expression: " + num + " is even: " + result);
	        // Here, a method reference to  static method isEven of IntPredicatesChecker is passed to numCheck().
	        result = demo.numCheck(IntPredicatesChecker::isEven, num);
	        System.out.println("Using static method reference: " + num + " is even: " + result);
	        // Here, Using lambda expression to check if a number is positive
	        IntPredicate lb2 = number -> number > 0;
	        result = demo.numCheck(lb2, num);
	        System.out.println("Using lambda expression: " + num + " is positive: " + result);
	        // Here, a method reference to  static method isPositive of IntPredicatesChecker is passed to numCheck().
	        result = demo.numCheck(IntPredicatesChecker::isPositive, num);
	        System.out.println("Using static method reference: " + num + " is positive: " + result);
	        
	        
	        //Using Anonymous local class
	        IntPredicate posChecker = new IntPredicate(){
	        	@Override
	        	public boolean check(int i){
	        		return (i>0)?true:false;
	        	}
	        	
	        };
	        
	        result = demo.numCheck(posChecker, num);
	        System.out.println("Using anonymous local class: " + num + " is positive: " + result);
	        
	        IntPredicate evenChecker = new IntPredicate(){
	        	@Override
	        	public boolean check(int i){
	        		return (i%2==0)?true:false;
	        	}
	        	
	        };
	        result = demo.numCheck(evenChecker, num);
	        System.out.println("Using anonymous local class: " + num + " is even: " + result);
	    }

}


@FunctionalInterface
interface IntPredicate {
    boolean check(int i);
}
class IntPredicatesChecker {
    // A static method for checking if  a number is positive
    public static boolean isPositive(int n) {
        return n > 0;
    }
    // A static method for checking if a number is even
    public static boolean isEven(int n) {
        return (n % 2) == 0;
    }
}