package finalInitialize;

import java.util.ArrayList;
import java.util.List;

class UnderstandingInitializationOfFinal1 {
	/*Primitive Scenario*/
	
	//compile issue as final instance variable must be initialized
	//final int var;
	final int var = 2;
	
	/*Reference Scenario*/
	//compile issue as final instance variable must be initialized
	//final List<ArrayList> list;
	final List<String> list = new ArrayList<>();
	
}

//Following Scenarios are true for final reference instance variable as well.

class UnderstandingInitializationOfFinal2 {
	
	final int var;
	//using constructor
	public UnderstandingInitializationOfFinal2() {
		var = 2;
	}
	
}

class UnderstandingInitializationOfFinal3 {
	
	final int var;
	//using instance block
	{var = 3;}
	
}

class UnderstandingInitializationOfFinal4 {
	
	//only if along with final the variable is also static then to initialize the variable 
	//we can use a static block/inline initialization via constant expression. As static block can only refer static references directly.
	static final int var;
	//using static block
	static{var = 3;}
	

}


class UnderstandingInitializationOfFinal5 {
	
	final int var;
	
	//in case of multiple constructor every constructor must initialize the final variable
	
	//constructor1
	public UnderstandingInitializationOfFinal5() {
		var = 2;
	}
	
	//constructor2
	public UnderstandingInitializationOfFinal5(float justAnotherParameter) {
		var = 2;
	}
	

}


class UnderstandingInitializationOfFinal6 {
	
	final int var;
	
	//Even though it looks like previous scenario where we had multiple constructor, it is not same. We can see that there is a
	//presence of constructor chaining and thus Java Compiler is not sure whethere the constructor it depends on already initializes
	//the final variable.
	
	
	/*public UnderstandingInitializationOfFinal6() {
		this(4.5f);
		var = 2;
	}
	
	
	public UnderstandingInitializationOfFinal6(float justAnotherParameter) {
		var = 2;
	}*/
	
	//As a solution the constructor which will be called executed first in the constructor chain, it will be
	//responsibility of that constructor to initialize the final variable.
	
	//constructor1
	public UnderstandingInitializationOfFinal6() {
		this(4.5f);
	}
	
	//constructor2
	public UnderstandingInitializationOfFinal6(float justAnotherParameter) {
		var = 2;
	}
	
	

}

