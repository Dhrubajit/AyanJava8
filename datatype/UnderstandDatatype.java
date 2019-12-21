package datatype;

public class UnderstandDatatype {

	public static void main(String[] args) {
		double data = 7918239184182987129317998317928379182739182739182371982371928371923719283719287.9;
		char ch = 'a';
		Byte c = 8;
		Byte b;
		
		
		int hourOfDay=0;
		int somethingElse = 1;
		if(hourOfDay < 15) {
			 System.out.println("Good Afternoon");
			} else if(somethingElse == 1) {
			 System.out.println("Good Morning"); // UNREACHABLE CODE. But, compiler can't understand.
			} else {
			 System.out.println("Good Evening");
			}
		int y = 10;
		
	}

}
