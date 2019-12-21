package functionainterface;

public class UnderstandingFunctionalInterface {
	public static void main(String[] args) {
		MyFirstFunctionalInterface myFirst = () -> System.out.println("myFirst");
		myFirst.singleAbstractMethod();
		MySecondFunctionalInterface mySecond = () -> System.out.println("myScond");
		mySecond.secondAbstractMethod();
		MyThirdFunctionalInterface myThird = () -> System.out.println("myThird");
		myThird.thirdAbstractMethod();
	}
}

//This annotation is not necessary.It is same as @Override. As long as interface 
//has only one abstract method, it will continue to behave as a functional interface
//and we can write lamda without compile issue.
@FunctionalInterface
interface MyFirstFunctionalInterface{
	void singleAbstractMethod();
	
}

// If an interface declares an abstract method overriding one of the public methods of
//java.lang.Object, that also does not count toward the interface's abstract method count
//since any implementation of the interface will have an implementation from java.lang.Object
//or elsewhere.
@FunctionalInterface
interface MySecondFunctionalInterface{
	void secondAbstractMethod();
	String toString();
}


@FunctionalInterface
interface MyThirdFunctionalInterface{
	void thirdAbstractMethod();
	static void myStaticMethodInsideFunctionalInterface(){
		System.out.println("myStaticMethodInsideFunctionalInterface");
	}
	default void myDefaultMethodInsideFunctionalInterface(){
		System.out.println("myDefaultMethodInsideFunctionalInterface");
	}
}

@FunctionalInterface
interface MyFourthFunctionalInterface extends MyFirstFunctionalInterface{
	void fourthAbstractMethod();
	
	default void singleAbstractMethod(){
		System.out.println("this method is overridden that is why MyFourthFunctionalInterface interface becomes Functional Interface");
	}
}