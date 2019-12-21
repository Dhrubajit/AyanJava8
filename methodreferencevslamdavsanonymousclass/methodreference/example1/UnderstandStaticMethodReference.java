package methodreferencevslamdavsanonymousclass.methodreference.example1;

//Equivalent Lamda Expression - (args) -> ClassName.staticMethodName(args)
public class UnderstandStaticMethodReference {

	 public boolean numCheck(IntPredicate p, int n) {
	        return p.check(n);
	    }
	    public static void main(String[] args) {
	    	UnderstandStaticMethodReference demo = new UnderstandStaticMethodReference();
	        boolean result;
	        int num = 9;
	        
	        // Here, a method reference to  static method isEven of IntPredicatesChecker is passed to numCheck().
	        result = demo.numCheck(IntPredicatesChecker::isEven, num);
	        System.out.println("Using static method reference: " + num + " is even: " + result);
	        
	        // Here, a method reference to  static method isPositive of IntPredicatesChecker is passed to numCheck().
	        result = demo.numCheck(IntPredicatesChecker::isPositive, num);
	        System.out.println("Using static method reference: " + num + " is positive: " + result);
	        
	       
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