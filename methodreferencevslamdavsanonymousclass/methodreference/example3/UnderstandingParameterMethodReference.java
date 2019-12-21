package methodreferencevslamdavsanonymousclass.methodreference.example3;


//Equivalent Lamda Expression - (arg0,rest) -> arg0.instanceMethodName(rest)
//Note: argo is of type ClassName
public class UnderstandingParameterMethodReference {

	public static void main(String[] args) {
		IntNumChecker checker1 = new IntNumChecker(10);
        int numToCompare = 9;
        IntNumPredicate p = IntNumChecker::isBigger;
        boolean result = p.check(checker1,9);
        if (result) {
            System.out.println(checker1.getNum() + " is bigger than " + numToCompare);
        }else {
            System.out.println(checker1.getNum() + " is smaller  " + numToCompare);
        }
        // second object of IntNumChecker
        IntNumChecker checker2 = new IntNumChecker(8);
        result = p.check(checker2,9);
        if (result) {
            System.out.println(checker2.getNum() + " is bigger than " + numToCompare);
        }else {
            System.out.println(checker2.getNum() + " is smaller " + numToCompare);
        }

	}

}



@FunctionalInterface
interface IntNumPredicate {
    boolean check(IntNumChecker m, int n);
}



class IntNumChecker {
    final private int num;
    public IntNumChecker(int num) {
        this.num = num;
    }
    // check if num is bigger than the input value n
    boolean isBigger(int n) {
        return num > n;
    }
    
    public int getNum(){
    	return num;
    }
}
