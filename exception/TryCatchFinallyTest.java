package exception;

public class TryCatchFinallyTest {

	public static void main(String[] args){
	}

	public static void method1(){
		try{
			//No problem if we catch and exception or any child of RuntimeException
			//even though code inside try block does not throw it.
		}
		catch(Exception e){
		}
	}

	public static void method2(){
		throw new RuntimeException();
		//Unlike method1, this will give compilation as Exception is parent
		//of checked exception
		//throw new Exception();
	}

	public static void method3(){
		/*try{
			//If try block does not throw a checked exception and we try to catch it
			//then this will be an compilation issue
		}catch(IOException e){
		}*/
	}



}
