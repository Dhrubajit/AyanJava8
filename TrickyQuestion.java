
//will the following code compile
class TrickyQuestion1 {
	//This code will work instead of the fact that it looks like we are assigning final variable multiple times. 
	//But, we also have to consider the fact that each time the loop runs the scope of the variable is new.
	static void run(){
		int[] arr = {1,2,3};
		for(final int i:arr){
			//do Something with array
		}
	}
	
}

class TrickyQuestion2 {
	
	static void run(){
		//Following can not be written as overloading can not resolved by compiler.
		//System.out.println(null);
	}
	
}
