package abstractClass;

public abstract class UnderstandAbstractClass {
	UnderstandAbstractClass(int i){
		System.out.println("Ayan");
	}
}

class Test{
	public static void main(String[] args) {
		UnderstandAbstractClass instance = new UnderstandAbstractClass(7){};
	}
}